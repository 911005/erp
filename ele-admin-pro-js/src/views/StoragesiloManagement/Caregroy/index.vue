<template>
  <div>
    <vxe-button status="primary" content="新增" @click="addCaregory()"></vxe-button>
    <vxe-table
      show-overflow
      :row-config="{isHover: true, useKey: true}"
      :column-config="{resizable: true}"
      :tree-config="{transform: true, rowField: 'id', parentField: 'pid', line: true,expandAll: true}"
      :data="demo.caregorys"
      :scroll-y="{enabled: false}">
      <vxe-column field="caregory" title="类别名称" tree-node></vxe-column>
      <vxe-column field="id" title="本级id"></vxe-column>
      <vxe-column title="操作" width="240">
        <template #default="{ row }">
          <vxe-button v-if="row.children.length === 0" status="warning" content="编辑" @click="updateEvent(row)"></vxe-button>
          <vxe-button v-if="row.children.length === 0" status="danger" content="删除" @click="deleteEvent(row)"></vxe-button>
        </template>

      </vxe-column>
    </vxe-table>

    <!--  编辑弹窗-->
    <vxe-modal v-model="demo.status" :title=" '编辑&保存'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
      <vxe-form :data="demo.updateData" title-align="right" title-width="100" >
        <vxe-form-item title="Basic information" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
<!--        <vxe-form-item field="id" title="编号" :span="12" :item-render="{}">-->
<!--          <template #default="{ data }">-->
<!--            <vxe-input v-model="data.parentid" placeholder="请输入编号：" ></vxe-input>-->
<!--          </template>-->
<!--        </vxe-form-item>-->
        <vxe-form-item field="caregory" title="类别名称" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.caregory" placeholder="请输入类别名称："></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item align="center" title-align="left" :span="24">
          <template #default>
            <vxe-button @click="submitEvent">提交</vxe-button>
            <vxe-button type="reset">重置</vxe-button>
          </template>
        </vxe-form-item>
      </vxe-form>
    </vxe-modal>

    <!--  新增弹窗-->
    <vxe-modal v-model="demo.addStatus" :title=" '新增&保存'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
      <vxe-form :data="demo.addData" title-align="right" title-width="100" >
        <vxe-form-item title="Basic information" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
        <vxe-form-item field="caregory" title="类别名称" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.caregory" placeholder="请输入类别名称："></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="pid" title="父节点" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.pid" placeholder="请输入父节点"></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item align="center" title-align="left" :span="24">
          <template #default>
            <vxe-button @click="addEvent">提交</vxe-button>
            <vxe-button type="reset">重置</vxe-button>
          </template>
        </vxe-form-item>
      </vxe-form>
    </vxe-modal>
  </div>
</template>

<script>
import {reactive,onMounted} from "vue";
import request from "@/utils/request";
export default {
  name: "index",
  setup() {
    onMounted(() => {
      findCaregorys()
    })
    const demo = reactive({
      caregorys: [],
      status: false,
      addStatus: false,
      updateData: [],
      addData: []
    })
    const findCaregorys = async () => {
      console.log(111)
      const res = await request.get('/caregory/caregory/findAllCaregorys');
      console.log(res)
      demo.caregorys = res.data
      console.log(demo.caregorys)
      return res
    }
    const addCaregory=async () => {
      demo.addStatus=true
    }
    const addEvent = async() => {
      demo.addstatus = false;
      let data={
        caregory:demo.addData.caregory,
        pid:demo.addData.pid
      }
      console.log(data)
      const res=await request.post('/caregory/caregory/addCaregory',data)
      console.log(demo.addData)
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    };

    const updateEvent=(row)=>{
      demo.status=true
      demo.updateData=row
    }
    const submitEvent=async () => {
      console.log(demo.updateData)
      demo.status=false
      let data=demo.updateData
      const res = await request.put('/caregory/caregory/updateCaregory',data);
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }

    const deleteEvent=async (row) => {
      alert(row.caregory)
      const res = await request.delete('/caregory/caregory/deleteCaregory/'+row.caregory)
      if (res.data.code==0){
        return res.data.message
      }
      reload()
      return Promise.reject((new Error(res.data.message)))
    }

    return {
      demo,
      findCaregorys,
      addCaregory,
      addEvent,
      updateEvent,
      deleteEvent,
      submitEvent,
    };
  },

}
</script>

<style scoped>

</style>
