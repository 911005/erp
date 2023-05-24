<template>
  <div>
    <vxe-button status="primary" content="查询供应原材料" @click="findSupplyM()"></vxe-button>
    <vxe-button status="primary" content="新增供应原材料" @click="addSupplyM()"></vxe-button>
    <vxe-table
      :data="demo.SupplyMaterials">
      <vxe-column type="seq" width="60" field="materialid" title="编号"></vxe-column>
      <vxe-column field="platformmaterialname" title="平台原材料"></vxe-column>
      <vxe-column field="supplymaterialname" title="供应原材料"></vxe-column>
      <vxe-column field="specifications" title="规格类型"></vxe-column>
      <vxe-column title="操作" width="240">
        <template #default="{ row }">

          <vxe-button status="warning" content="编辑" @click="updateEvent(row)"></vxe-button>
          <vxe-button status="danger" content="删除" @click="deleteEvent(row)"></vxe-button>
        </template>
      </vxe-column>
    </vxe-table>

    <!--  编辑弹窗-->
    <vxe-modal v-model="demo.status" :title=" '新增&保存'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
      <vxe-form :data="demo.updateData" title-align="right" title-width="100" >
        <vxe-form-item title="Basic information" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
        <vxe-form-item field="type" title="平台原材料" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.platformmaterialname" placeholder="请输入平台原材料"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="type" title="供应原材料" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.supplymaterialname" placeholder="请输入供应原材料"></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="type" title="规格类型" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.specifications" placeholder="请输入规格类型"></vxe-input>
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
        <vxe-form-item field="platformmaterialname" title="平台原材料" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.platformmaterialname" placeholder="请输入平台原材料"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="supplymaterialname" title="供应原材料" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.supplymaterialname" placeholder="请输入供应原材料"></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="specifications" title="规格类型" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.specifications" placeholder="请输入规格类型"></vxe-input>
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
      findSupplyM()
    })
    const demo = reactive({
      SupplyMaterials: [],
      status: false,
      addStatus: false,
      updateData: [],
      addData: []
    })
    const findSupplyM = async () => {
      console.log(111)
      const res = await request.get('/test1/SupplyMaterials/findAllSupplyM');
      console.log(res)
      demo.SupplyMaterials = res.data
      console.log(demo.SupplyMaterials)
      return res
    }
    const deleteEvent = async (row) => {
      alert(row.materialid)
      const res = await request.delete('/test1/SupplyMaterials/deleteSupplyM/' + row.materialid)
      if (res.data.code == 0) {
        return res.data.message
      }
      location.reload()
      return Promise.reject((new Error(res.data.message)))
    }
    const updateEvent = (row) => {
      demo.status = true
      demo.updateData = row
    }

    const submitEvent = async () => {
      console.log(demo.updateData)
      demo.status = false
      let data = demo.updateData
      const res = await request.put('/test1/SupplyMaterials/updateSupplyM', data);
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }

    const addSupplyM = async () => {
      demo.addStatus = true
    }

    const addEvent = async () => {
      demo.addStatus = false
      let data = {
        platformmaterialname: demo.addData.platformmaterialname,
        supplymaterialname: demo.addData.supplymaterialname,
        specifications: demo.addData.specifications
      }
      console.log(data)
      const res = await request.put('/test1/SupplyMaterials/addSupplyM', data)
      console.log(demo.addData)
      if (res.data.code === 0) {
        return res.data.message;
      }
      location.reload()
      return Promise.reject(new Error(res.data.message));
    }

    return {
      demo,
      findSupplyM,
      deleteEvent,
      updateEvent,
      submitEvent,
      addSupplyM,
      addEvent
    }
  },

}

</script>

<style scoped>

</style>
