<template>
  <div>
    <vxe-button status="primary" content="新增" @click="addProduction()"></vxe-button>
    <vxe-table
      show-overflow
      :row-config="{isHover: true, useKey: true}"
      :column-config="{resizable: true}"
      :tree-config="{transform: true, rowField: 'id', parentField: 'parentid', line: true}"
      :data="demo.productions"
      :scroll-y="{enabled: false}">
      <vxe-column field="propertyname" title="产品名称" tree-node></vxe-column>
      <vxe-column field="id" title="本级id"></vxe-column>
      <vxe-column field="subproperty" title="等级"></vxe-column>
      <vxe-column field="propertystate" title="状态"></vxe-column>
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

        <!--        <vxe-form-item field="propertyname" title="名称" :span="12" :item-render="{}">-->
        <!--          <template #default="{ data }">-->
        <!--            <vxe-input v-model="data.propertyname" placeholder="请输入产品名称" disabled></vxe-input>-->
        <!--          </template>-->
        <!--        </vxe-form-item>-->
        <vxe-form-item field="parentid" title="父节点" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.parentid" placeholder="请输入产品父节点" disabled></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="subproperty" title="等级" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.subproperty" placeholder="请输入产品等级"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="propertystate" title="状态" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.propertystate" placeholder="请输入产品状态"></vxe-input>
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
        <!--        <vxe-form-item field="propertyname" title="名称" :span="12" :item-render="{}">-->
        <!--          <template #default="{ data }">-->
        <!--            <vxe-input v-model="data.propertyname" placeholder="请输入产品等级"></vxe-input>-->
        <!--          </template>-->
        <!--        </vxe-form-item>-->
        <vxe-form-item field="parentid" title="父节点" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.parentid" placeholder="请输入产品等级"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="subproperty" title="等级" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.subproperty" placeholder="请输入产品等级"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="propertystate" title="状态" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.propertystate" placeholder="请输入产品等级"></vxe-input>
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
      findProduction()
    })
    const demo = reactive({
      productions: [],
      status: false,
      addStatus: false,
      updateData: [],
      addData: []
    })
    const findProduction = async () => {
      console.log(111)
      const res = await request.get('/production/production/findAllProductions');
      console.log(res)
      demo.productions = res.data
      console.log(demo.productions)
      return res
    }
    const addProduction=async () => {
      demo.addStatus=true
    }
    const addEvent = async() => {
      demo.addStatus = false;
      let data={
        propertyname:demo.addData.propertyname,
        parentid:demo.addData.parentid,
        subproperty:demo.addData.subproperty,
        propertystate:demo.addData.propertystate
      }
      console.log(data)
      const res=await request.post('/production/production/addProduction',data)
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
      const res = await request.put('/production/production/updateProduction',data);
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }

    const deleteEvent=async (row) => {
      alert(row.id)
      const res = await request.delete('/production/production/deleteProduction/'+row.id)
      if (res.data.code==0){
        return res.data.message
      }
      reload()
      return Promise.reject((new Error(res.data.message)))
    }

    return {
      demo,
      addProduction,
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
