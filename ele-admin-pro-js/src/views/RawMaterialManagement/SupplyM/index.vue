<template>
  <div>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <vxe-input v-model="demo.searchInput" placeholder="请输入供应原材料" type="search" ></vxe-input>
    <vxe-button status="primary" content="查询" @click="findSupplyMById()"></vxe-button>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <vxe-button style="padding-right: 10px" status="primary" content="刷新" @click="findSupplyM()"></vxe-button>
    <vxe-button style="padding-right: 10px" status="primary" content="新增" @click="addSupplyM()"></vxe-button>
    <vxe-table
      height="595"
      :span-method="objectSpanMethod"
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
    <vxe-modal v-model="demo.value5" width="1000" show-footer>
      <vxe-table
        stripe
        :span-method="colspanMethod"
        :data="demo.materials">
        <vxe-column type="seq" width="60" field="id" title="编号"></vxe-column>
        <vxe-column field="rawname" title="名称"></vxe-column>
        <vxe-column field="model" title="规格型号"></vxe-column>
        <vxe-column field="operate" title="operate" #default="{ row }">
          <vxe-button type="text" status="danger" content="添加" @click="addMaterials(row)"></vxe-button>
        </vxe-column>
      </vxe-table>
    </vxe-modal>

    <!--  编辑弹窗-->
    <vxe-modal v-model="demo.status" :title=" '编辑'" width="800" height="395" min-width="600" min-height="300"  resize destroy-on-close>
      <vxe-form :data="demo.updateData" title-align="right" title-width="100" >
        <vxe-form-item title="原材料" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
        <vxe-form-item field="platformmaterialname" title="平台原材料" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="demo.updateData.platformmaterialname" :model-value="demo.updateData.platformmaterialname" placeholder="平台原材料" @click="selectAllMats"></vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="supplymaterialname" title="供应原材料" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.supplymaterialname" placeholder="供应原材料"></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="specifications" title="规格类型" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="demo.updateData.specifications" placeholder="规格类型"></vxe-input>
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
    <vxe-modal v-model="demo.addStatus" :title=" '新增'" width="800" height="395" min-width="600" min-height="300"  resize destroy-on-close>
      <vxe-form :data="demo.addData" title-align="right" title-width="100" >
        <vxe-form-item title="原材料" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
        <vxe-form-item field="platformmaterialname" title="平台原材料" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="demo.addData.platformmaterialname" :model-value="demo.addData.platformmaterialname" placeholder="平台原材料" @click="selectAllMats"></vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="supplymaterialname" title="供应原材料" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.supplymaterialname" placeholder="供应原材料"></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="specifications" title="规格类型" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="demo.addData.specifications" placeholder="规格类型"></vxe-input>
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
      findmaterials()
      findAllmaterials()
    })
    const demo = reactive({
      value5:false,
      materials:[],
      options:[],
      searchInput: [],
      SupplyMaterials: [],
      status: false,
      addStatus: false,
      updateData: {
        platformmaterialname:'',
        specifications:'',
      },
      addData: {
        platformmaterialname:'',
        specifications:'',
      }
    })

    const objectSpanMethod= async ({ row, column, rowIndex, visibleData }) =>{
      const fields=['platformmaterialname']
      const cellValue = row[column.property]
      if (cellValue && fields.includes(column.property)){
        const prevRow = visibleData[rowIndex-1]
        let nextRow = visibleData[rowIndex + 1]
        if (prevRow && prevRow[column.property] === cellValue) {
          return { rowspan: 0, colspan: 0 }
        } else {
          let countRowspan = 1
          while (nextRow && nextRow[column.property] === cellValue) {
            nextRow = visibleData[++countRowspan + rowIndex]
          }
          if (countRowspan > 1) {
            return {rowspan: countRowspan, colspan: 1}
          }
        }
      }
    }
    const findAllmaterials = async () =>{
      console.log(111)
      const res = await request.get('/materials/materials/findmaterials');
      console.log(res)
      demo.materials= res.data
      console.log(demo.materials)
      return res
    }
    const selectAllMats=async ()=>{
      demo.value5=true
    }
    const addMaterials=async (row)=>{
      if (demo.addStatus){
        demo.addData.platformmaterialname=row.rawname;
        demo.addData.specifications=row.model;
      }
      else if (demo.status){
        demo.updateData.platformmaterialname=row.rawname;
        demo.updateData.specifications=row.model;
      }
      demo.value5=false;
    }
    const findmaterials = async () =>{
      console.log(111)
      const res = await request.get('/materials/materials/findmaterials');
      const data=res.data
      if (data && data.length > 0) {
        demo.options = data.map(item => {
          return { value: item.rawname, label: item.rawname };
        });
      }
      return res
    }
    const findSupplyM = async () => {
      console.log(111)
      const res = await request.get('/test1/SupplyMaterials/findAllSupplyM');
      console.log(res)
      demo.SupplyMaterials = res.data
      console.log(demo.SupplyMaterials)
      return res
    }
    const findSupplyMById = async () =>{
      const res = await request.get('/test1/SupplyMaterials/findSupplyMById/' +demo.searchInput);
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
      const res = await request.post('/test1/SupplyMaterials/addSupplyM', data)
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
      findAllmaterials,
      findmaterials,
      selectAllMats,
      addMaterials,
      deleteEvent,
      updateEvent,
      submitEvent,
      addSupplyM,
      addEvent,
      objectSpanMethod,
      findSupplyMById
    }
  },

}

</script>

<style scoped>

</style>
