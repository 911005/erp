<template>
  <div>
    &nbsp;&nbsp;&nbsp;&nbsp;<vxe-input v-model="demo.searchInput1" placeholder="请输入车辆编号" type="search" ></vxe-input>
    <vxe-button status="primary" content="查询" @click="selectBycarid()"></vxe-button>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<vxe-input v-model="demo.searchInput2" placeholder="请输入车牌号" type="search" ></vxe-input>
    <vxe-button status="primary" content="查询" @click="selectByCarNumber()"></vxe-button>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<vxe-input v-model="demo.searchInput3" placeholder="请输入负责人" type="search" ></vxe-input>
    <vxe-button status="primary" content="查询" @click="selectBypersonInCharge()"></vxe-button>
    <vxe-button status="primary" content="刷新" @click="findCars()"></vxe-button>
    <vxe-button status="primary" content="新增" @click="addCar()"></vxe-button>
    <vxe-table
      :data="demo.cars">
      <vxe-column type="seq" width="60" field="id" title="编号"></vxe-column>
      <vxe-column field="carid" title="车辆编号"></vxe-column>
      <vxe-column field="status" title="状态"></vxe-column>
      <vxe-column field="carnumber" title="车牌号"></vxe-column>
      <vxe-column field="caridennumber" title="车辆识别码"></vxe-column>
      <vxe-column field="gpsidennumber" title="GPS识别码"></vxe-column>
      <vxe-column field="subunit" title="所属单位"></vxe-column>
      <vxe-column field="personincharge" title="责任人"></vxe-column>
      <vxe-column field="remarks" title="备注"></vxe-column>
      <vxe-column title="操作" width="240">
        <template #default="{ row }">

          <vxe-button status="warning" content="编辑" @click="updateEvent(row)"></vxe-button>
          <vxe-button status="danger" content="删除" @click="deleteEvent(row)"></vxe-button>
        </template>
      </vxe-column>
    </vxe-table>

    <!--  编辑弹窗-->
    <vxe-modal v-model="demo.status" :title=" '编辑'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
      <vxe-form :data="demo.updateData" title-align="right" title-width="100" >
        <vxe-form-item title="运输车辆" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
        <vxe-form-item field="carid" title="车辆编号" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.carid" placeholder="车辆编号"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="status" title="状态" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.status" placeholder="状态">
              <vxe-option :value="'启用'" label="启用"></vxe-option>
              <vxe-option :value="'停用'" label="停用"></vxe-option>
            </vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="carnumber" title="车牌号" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.carnumber" placeholder="车牌号"></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="caridennumber" title="车辆识别码" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.caridennumber" placeholder="车辆识别码"></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="gpsidennumber" title="GPS识别码" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.gpsidennumber" placeholder="GPS识别码"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="subunit" title="所属单位" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.subunit" placeholder="所属单位"></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="personincharge" title="责任人" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.personincharge" placeholder="责任人"></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="remarks" title="备注" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.remarks" placeholder="备注"></vxe-input>
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
    <vxe-modal v-model="demo.addStatus" :title=" '新增'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
      <vxe-form :data="demo.addData" title-align="right" title-width="100" >
        <vxe-form-item title="运输车辆" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
        <vxe-form-item field="carid" title="车辆编号" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.carid" placeholder="车辆编号"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="status" title="状态" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.status" placeholder="状态">
              <vxe-option :value="'启用'" label="启用"></vxe-option>
              <vxe-option :value="'停用'" label="停用"></vxe-option>
            </vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="carnumber" title="车牌号" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.carnumber" placeholder="车牌号"></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="caridennumber" title="车辆识别码" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.caridennumber" placeholder="车辆识别码"></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="gpsidennumber" title="GPS识别码" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.gpsidennumber" placeholder="GPS识别码"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="subunit" title="所属单位" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.subunit" placeholder="所属单位"></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="personincharge" title="责任人" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.personincharge" placeholder="责任人"></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="remarks" title="备注" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.remarks" placeholder="备注"></vxe-input>
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
      findCars()
    })
    const demo = reactive({
      searchInput1: [],
      searchInput2: [],
      searchInput3: [],
      cars: [],
      status: false,
      addStatus: false,
      updateData: [],
      addData: []
    })
    const findCars = async () => {
      console.log(111)
      const res = await request.get('/car/car/findAllCars');
      console.log(res)
      demo.cars = res.data
      console.log(demo.cars)
      return res
    }
    const selectBycarid = async () =>{
      console.log(111)
      const res = await request.get('/car/car/selectBycarid/'+demo.searchInput1);
      console.log(res)
      demo.cars = res.data
      console.log(demo.cars)
      return res
    }
    const selectByCarNumber = async () =>{
      console.log(111)
      const res = await request.get('/car/car/selectByCarNumber/'+demo.searchInput2);
      console.log(res)
      demo.cars = res.data
      console.log(demo.cars)
      return res
    }
    const selectBypersonInCharge = async () =>{
      console.log(111)
      const res = await request.get('/car/car/selectBypersonInCharge/'+demo.searchInput3);
      console.log(res)
      demo.cars = res.data
      console.log(demo.cars)
      return res
    }
    const deleteEvent = async (row) => {
      alert(row.id)
      const res = await request.delete('/car/car/deleteCar/' + row.id)
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
      const res = await request.put('/car/car/updateCar', data);
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }

    const addCar = async () => {
      demo.addStatus = true
    }

    const addEvent = async () => {
      demo.addStatus = false
      let data = {
        carid: demo.addData.carid,
        status: demo.addData.status,
        carnumber: demo.addData.carnumber,
        caridennumber: demo.addData.caridennumber,
        gpsidennumber: demo.addData.gpsidennumber,
        subunit: demo.addData.subunit,
        personincharge: demo.addData.personincharge,
        remarks: demo.addData.remarks
      }
      console.log(data)
      const res = await request.post('/car/car/addCar', data)
      console.log(demo.addData)
      if (res.data.code === 0) {
        return res.data.message;
      }
      location.reload()
      return Promise.reject(new Error(res.data.message));
    }

    return {
      demo,
      findCars,
      deleteEvent,
      updateEvent,
      submitEvent,
      addCar,
      addEvent,
      selectByCarNumber,
      selectBycarid,
      selectBypersonInCharge
    }
  },

}

</script>

<style scoped>

</style>
