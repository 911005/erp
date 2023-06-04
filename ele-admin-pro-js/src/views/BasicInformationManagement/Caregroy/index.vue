<template>
  <div style="float: left;width: 400px;">
    <vxe-button status="primary" content="新增" @click="addCaregory()"></vxe-button>
    <vxe-table
      show-overflow
      border
      height="595"
      :row-config="{isCurrent: true,isHover: true, useKey: true}"
      :column-config="{resizable: true}"
      :tree-config="{transform: true, rowField: 'id', parentField: 'pid', line: true,expandAll: true}"
      :data="demo.caregorys"
      :scroll-y="{enabled: false}">
      <vxe-column field="caregory" title="类别名称" tree-node></vxe-column>
      <vxe-column title="操作" width="240">
        <template #default="{ row }">
          <vxe-button v-if="row.children.length === 0" status="success" icon="vxe-icon-square-right" @click="selectEvent(row)"></vxe-button>
          <vxe-button v-if="row.children.length === 0" status="warning" icon="vxe-icon-edit" @click="updateEvent(row)"></vxe-button>
          <vxe-button v-if="row.children.length === 0" status="danger" icon="vxe-icon-delete" @click="deleteEvent(row)"></vxe-button>
        </template>

      </vxe-column>
    </vxe-table>

    <!--  编辑弹窗-->
    <vxe-modal v-model="demo.status" :title=" '编辑&保存'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
      <vxe-form :data="demo.updateData" title-align="right" title-width="100" >
        <vxe-form-item title="Basic information" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
        <vxe-form-item field="caregory" title="类别名称" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.caregory" placeholder="请输入类别名称"></vxe-input>
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
            <vxe-input v-model="data.caregory" placeholder="请输入类别名称"></vxe-input>
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
  <div style="float:right;width: 900px;">
    <vxe-button status="primary" content="查询所有信息" @click="findmaterials()"></vxe-button>
    <vxe-button status="primary" content="新增" @click="addmaterials()"></vxe-button>
    <vxe-table
      border
      height="595"
      :data="demo.materials">
      <vxe-column field="rawname" title="名称"></vxe-column>
      <!--      <vxe-column field="caregoryid" title="类别名称"></vxe-column>-->
      <vxe-column field="model" title="规格型号"></vxe-column>
      <vxe-column field="unitofmeasurement" title="计量单位"></vxe-column>
      <vxe-column field="status" title="状态"></vxe-column>
      <vxe-column title="操作" width="240">
        <template #default="{ row }">

          <vxe-button status="warning" content="编辑" @click="updateEventNew(row)"></vxe-button>
          <vxe-button status="danger" content="删除" @click="deleteEventNew(row)"></vxe-button>
        </template>
      </vxe-column>
    </vxe-table>


    <!--  编辑弹窗-->
    <vxe-modal v-model="demo.statusNew" :title=" '编辑&保存'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
      <vxe-form :data="demo.updateDataNew" title-align="right" title-width="100" >
        <vxe-form-item title="Basic information" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
        <vxe-form-item field="rawname" title="名称" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.rawname" placeholder="请输入名称" ></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="caregory" title="类别" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.caregoryid" :options="demo.options" placeholder="请输入类别"></vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="model" title="规格型号" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.model" placeholder="请输入规格型号"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="unitofmeasurement" title="计量单位" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.unitofmeasurement" placeholder="请输入计量单位"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item align="center" title-align="left" :span="24">
          <template #default>
            <vxe-button @click="submitEventNew">提交</vxe-button>
            <vxe-button type="reset">重置</vxe-button>
          </template>
        </vxe-form-item>
      </vxe-form>
    </vxe-modal>

    <!--  新增弹窗-->
    <vxe-modal v-model="demo.addStatusNew" :title=" '新增&保存'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
      <vxe-form :data="demo.addDataNew" title-align="right" title-width="100" >
        <vxe-form-item title="Basic information" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
        <vxe-form-item field="rawname" title="名称" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.rawname" placeholder="请输入名称" ></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="caregory" title="类别" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.caregoryid" :options="demo.options" placeholder="请输入类别"></vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="model" title="规格型号" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.model" placeholder="请输入规格型号"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="unitofmeasurement" title="计量单位" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.unitofmeasurement" placeholder="请输入计量单位" ></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="status" title="状态" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.status" placeholder="请输入状态"></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item align="center" title-align="left" :span="24">
          <template #default>
            <vxe-button @click="addEventNew">提交</vxe-button>
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
      findCaregorys(),
        findmaterials(),
        findCaregoryToMaterials()
    })
    const demo = reactive({
      materials:[],
      caregorys: [],
      options:[],
      status: false,
      addStatus: false,
      updateData: [],
      addData: [],
      statusNew: false,
      addStatusNew: false,
      updateDataNew: [],
      addDataNew: []
    })
    const findmaterials = async () =>{
      console.log(111)
      const res = await request.get('/materials/materials/findmaterials');
      console.log(res)
      demo.materials= res.data
      console.log(demo.materials)
      return res
    }
    const selectEvent = async (row) =>{
      const res = await request.get('/materials/materials/findmaterialsByCaregory/'+row.id);
      console.log(res)
      demo.materials= res.data
      console.log(demo.materials)
      return res
    }
    const findCaregoryToMaterials=async () => {
      const res = await request.get('/caregory/caregory/findCaregorys');
      const data=res.data
      if (data && data.length > 0) {
        demo.options = data.map(item => {
          return { value: item.id, label: item.caregory };
        });
      }
      return res
    }
    const addmaterials=async () => {
      demo.addStatusNew=true
    }
    const addEventNew = async() => {
      demo.addstatusNew = false;
      let data={
        rawname:demo.addDataNew.rawname,
        model:demo.addDataNew.model,
        caregoryid:demo.addDataNew.caregoryid,
        unitofmeasurement:demo.addDataNew.unitofmeasurement,
        status: demo.addDataNew.status
      }
      console.log(data)
      const res=await request.post('/materials/materials/addmaterials',data)
      console.log(demo.addDataNew)
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    };

    const updateEventNew=(row)=>{
      // // 将选项的 value 值转换为 label 值
      // const category = demo.options.find(option => option.value === row.category)
      // if (category) {
      //   row.category_label = category.label
      // }
      demo.statusNew=true
      demo.updateDataNew=row
    }
    const submitEventNew=async () => {
      console.log(demo.updateDataNew)
      demo.statusNew=false
      let data=demo.updateDataNew
      const category = demo.options.find(option => option.value === data.category)
      if (category) {
        data.category_label = category.label
      }
      // data.caregory=caregory.label
      // let data = Object.assign({}, demo.updateDataNew)
      // // 将选项的 label 值转换回 value 值
      // const category = demo.options.find(option => option.label === data.category_label)
      // if (category) {
      //   data.category = category.value
      // }
      const res = await request.put('/materials/materials/updateMaterials',data);
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }
    const formatCategory = ({ cellValue }) => {
      // 在选项列表中查找对应的 label 值
      const option = options.find(option => option.value === cellValue)
      return option ? option.label : ''
    }
    const deleteEventNew=async (row) => {
      alert(row.rawname)
      const res = await request.delete('/materials/materials/deleltematerials/'+row.rawname)
      if (res.data.code==0){
        return res.data.message
      }
      reload()
      return Promise.reject((new Error(res.data.message)))
    }
    const findCaregorys = async () => {
      console.log(111)
      const res = await request.get('/caregory/caregory/findAllCaregorys');
      console.log(res)
      demo.caregorys = res.data
      demo.options = res.data.caregory
      console.log(demo.caregorys)
      return res
    }
    const addCaregory=async () => {
      demo.addStatus=true
    }
    const addEvent = async() => {
      demo.addStatus = false;
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
      findmaterials,
      findCaregoryToMaterials,
      addCaregory,
      addEvent,
      updateEvent,
      deleteEvent,
      submitEvent,
      selectEvent,
      addmaterials,
      addEventNew,
      updateEventNew,
      deleteEventNew,
      submitEventNew,
      formatCategory
    };
  },

}
</script>

<style scoped>

</style>
