<template>
<div>
  &nbsp;&nbsp;&nbsp;&nbsp;
  <vxe-input v-model="dr.searchInput1" placeholder="请输入工号" type="search" ></vxe-input>
  <vxe-button status="primary" content="查询" @click="findDriversByjobNumber()"></vxe-button>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <vxe-input v-model="dr.searchInput2" placeholder="请输入司机名字" type="search" ></vxe-input>
  <vxe-button status="primary" content="查询" @click="findDriversBydriverName()"></vxe-button>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <vxe-button status="primary" content="刷新" @click="findDrivers()"></vxe-button>
  <vxe-button status="primary" content="新增" @click="addDriver()"></vxe-button>
  <vxe-table
    :data="dr.drivers">
    <vxe-column type="seq" width="60" field="id" title="编号"></vxe-column>
    <vxe-column field="jobnumber" title="工号"></vxe-column>
    <vxe-column field="drivername" title="司机姓名"></vxe-column>
    <vxe-column field="drivertype" title="司机类型"></vxe-column>
    <vxe-column field="drivercategory" title="司机类别"></vxe-column>
    <vxe-column field="driverphone" title="联系电话"></vxe-column>
    <vxe-column field="driverstate" title="司机状态"></vxe-column>
    <vxe-column title="操作" width="240">
      <template #default="{ row }">
        <vxe-button status="warning" content="编辑" @click="updateEvent(row)"></vxe-button>
        <vxe-button status="danger" content="删除" @click="deleteEvent(row)"></vxe-button>
      </template>
    </vxe-column>
  </vxe-table>

  <!--  编辑弹窗-->
  <vxe-modal v-model="dr.status" :title=" '新增&保存'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
    <vxe-form :data="dr.updateData" title-align="right" title-width="100" >
      <vxe-form-item title="司机" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
      <vxe-form-item field="jobnumber" title="工号" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.jobnumber" placeholder="工号"></vxe-input>
        </template>
      </vxe-form-item>
      <vxe-form-item field="drivername" title="司机姓名" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.drivername" placeholder="司机姓名"></vxe-input>
        </template>
      </vxe-form-item>
      <vxe-form-item field="drivertype" title="司机类型" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.drivertype" placeholder="司机类型">
            <vxe-option :value="'罐车司机'" label="罐车司机"></vxe-option>
            <vxe-option :value="'泵车司机'" label="泵车司机"></vxe-option>
          </vxe-select>
        </template>
      </vxe-form-item>
      <vxe-form-item field="drivercategory" title="司机类别" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.drivercategory" placeholder="司机类别">
            <vxe-option :value="'站内'" label="站内"></vxe-option>
            <vxe-option :value="'租方'" label="租方"></vxe-option>
          </vxe-select>
        </template>
      </vxe-form-item>
      <vxe-form-item field="driverphone" title="联系电话" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.driverphone" placeholder="联系电话"></vxe-input>
        </template>
      </vxe-form-item>
      <vxe-form-item field="driverstate" title="状态" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.driverstate" placeholder="状态">
            <vxe-option :value="'启用'" label="启用"></vxe-option>
            <vxe-option :value="'停用'" label="停用"></vxe-option>
          </vxe-select>
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
  <vxe-modal v-model="dr.addStatus" :title=" '新增&保存'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
    <vxe-form :data="dr.addData" title-align="right" title-width="100" >
      <vxe-form-item title="司机" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>

      <vxe-form-item field="jobnumber" title="工号" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.jobnumber" placeholder="工号"></vxe-input>
        </template>
      </vxe-form-item>
      <vxe-form-item field="drivername" title="司机姓名" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.drivername" placeholder="司机姓名"></vxe-input>
        </template>
      </vxe-form-item>
      <vxe-form-item field="drivertype" title="司机类型" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.drivertype" placeholder="司机类型">
            <vxe-option :value="'罐车司机'" label="罐车司机"></vxe-option>
            <vxe-option :value="'泵车司机'" label="泵车司机"></vxe-option>
          </vxe-select>
        </template>
      </vxe-form-item>
      <vxe-form-item field="drivercategory" title="司机类别" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.drivercategory" placeholder="司机类别">
            <vxe-option :value="'站内'" label="站内"></vxe-option>
            <vxe-option :value="'租方'" label="租方"></vxe-option>
          </vxe-select>
        </template>
      </vxe-form-item>
      <vxe-form-item field="driverphone" title="联系电话" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.driverphone" placeholder="联系电话"></vxe-input>
        </template>
      </vxe-form-item>
      <vxe-form-item field="driverstate" title="状态" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.driverstate" placeholder="状态">
              <vxe-option :value="'启用'" label="启用"></vxe-option>
              <vxe-option :value="'停用'" label="停用"></vxe-option>
          </vxe-select>
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
import {reactive, onMounted} from "vue";
import request from "@/utils/request";
export default {
  name: "index",
  setup() {
    onMounted(() => {
      findDrivers()
    })
    const dr = reactive({
      searchInput1:[],
      searchInput2:[],
      drivers: [],
      status: false,
      addStatus: false,
      updateData: [],
      addData: []
    })
    const findDrivers = async () => {
      console.log(111)
      const res = await request.get('/driver/driver/findAllDrivers');
      console.log(res)
      dr.drivers = res.data
      console.log(dr.drivers)
      return res
    }
    const findDriversByjobNumber = async () =>{
      const res = await request.get('/driver/driver/findDriversByjobNumber/' +dr.searchInput1);
      console.log(res)
      dr.drivers = res.data
      console.log(dr.drivers)
      return res
    }
    const findDriversBydriverName = async () =>{
      const res = await request.get('/driver/driver/findDriversBydriverName/' +dr.searchInput2);
      console.log(res)
      dr.drivers = res.data
      console.log(dr.drivers)
      return res
    }
    const updateEvent=(row)=>{
      dr.status=true
      dr.updateData=row
    }
    const submitEvent=async () => {
      console.log(dr.updateData)
      dr.status=false
      let data=dr.updateData
      const res = await request.put('/driver/driver/updateDriver',data);
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }
    const deleteEvent=async (row) => {
      alert(row.id)
      const res = await request.delete('/driver/driver/deleteDriver/'+row.id)
      if (res.data.code==0){
        return res.data.message
      }
      reload()
      return Promise.reject((new Error(res.data.message)))
    }
    const addDriver=async () => {
      dr.addStatus=true
    }

    const addEvent=async () => {
      dr.addStatus=false
      let data={
        jobnumber:dr.addData.jobnumber,
        drivername:dr.addData.drivername,
        drivertype:dr.addData.drivertype,
        drivercategory:dr.addData.drivercategory,
        driverphone:dr.addData.driverphone,
        driverstate:dr.addData.driverstate,
      }
      console.log(data)
      const res=await request.put('/driver/driver/addDriver',data)
      console.log(dr.addData)
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }
    return {
      dr,
      findDrivers,
      updateEvent,
      submitEvent,
      deleteEvent,
      addDriver,
      addEvent,
      findDriversByjobNumber,
      findDriversBydriverName
    }
  },
}
</script>

<style scoped>

</style>
