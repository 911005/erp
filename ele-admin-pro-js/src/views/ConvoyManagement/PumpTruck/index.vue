<template>
  <div>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <vxe-input v-model="demo.searchInput1" placeholder="请输入泵车编号" type="search" ></vxe-input>
    <vxe-button status="primary" content="查询" @click="findPumpTrucksBypumpTruckid()"></vxe-button>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <vxe-input v-model="demo.searchInput2" placeholder="请输入车牌号" type="search" ></vxe-input>
    <vxe-button status="primary" content="查询" @click="findPumpTrucksBypumpTruckNumber()"></vxe-button>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <vxe-button status="primary" content="刷新" @click="findPumpTrucks()"></vxe-button>
    <vxe-button status="primary" content="新增" @click="addPumpTruck()"></vxe-button>
    <vxe-table
      :cell-style="cellStyle"
      :data="demo.PumpTrucks">
      <vxe-column type="seq" width="60" field="id" title="编号"></vxe-column>
      <vxe-column field="pumptruckid" title="车辆编号"></vxe-column>
      <vxe-column field="pumptrucknumber" title="车牌号"></vxe-column>
      <vxe-column field="caridennumber" title="车辆识别码"></vxe-column>
      <vxe-column field="gpsidennumber" title="GPS识别码"></vxe-column>
      <vxe-column field="pumpingheight" title="泵送高度"></vxe-column>
      <vxe-column field="subunit" title="所属单位"></vxe-column>
      <vxe-column field="personincharge" title="责任人"></vxe-column>
      <vxe-column field="remarks" title="备注"></vxe-column>
      <vxe-column label="状态" field="status" title="状态"></vxe-column>
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
        <vxe-form-item title="泵车" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
        <vxe-form-item field="pumptruckid" title="车辆编号" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.pumptruckid" placeholder="车辆编号"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="pumptrucknumber" title="车牌号" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.pumptrucknumber" placeholder="车牌号"></vxe-input>
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

        <vxe-form-item field="pumpingheight" title="初始皮重" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.pumpingheight" placeholder="初始皮重" type="integer"></vxe-input>
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

        <vxe-form-item field="status" title="状态" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.status" placeholder="状态">
              <vxe-option :value="'空闲'" label="空闲"></vxe-option>
              <vxe-option :value="'泵送中'" label="泵送中"></vxe-option>
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
    <vxe-modal v-model="demo.addStatus" :title=" '新增'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
      <vxe-form :data="demo.addData" title-align="right" title-width="100" >
        <vxe-form-item title="泵车" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
        <vxe-form-item field="pumptruckid" title="车辆编号" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.pumptruckid" placeholder="车辆编号"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="pumptrucknumber" title="车牌号" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.pumptrucknumber" placeholder="车牌号"></vxe-input>
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

        <vxe-form-item field="pumpingheight" title="初始皮重" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.pumpingheight" placeholder="初始皮重" type="integer"></vxe-input>
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

        <vxe-form-item field="status" title="状态" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.status" placeholder="请输入状态">
              <vxe-option :value="'空闲'" label="空闲"></vxe-option>
              <vxe-option :value="'泵送中'" label="泵送中"></vxe-option>
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
import {reactive,onMounted,computed} from "vue";
import request from "@/utils/request";

export default {
  name: "index",
  setup() {
    onMounted(() => {
      findPumpTrucks()
    })
    const demo = reactive({
      searchInput1:[],
      searchInput2:[],
      PumpTrucks: [],
      status: false,
      addStatus: false,
      updateData: [],
      addData: []
    })
    const cellStyle = async (row,column,rowIndex,columnIndex) =>{
      let cellStyle;
      while (columnIndex==10){
        switch (row.status){
          case "空闲":
            cellStyle = 'color:#70DB93';
            break;
          case "停用":
            cellStyle = 'color:red';
            break;
          default:
            cellStyle = '';
        }
        if(column.label =="状态"){
          return cellStyle;
        }
      }
    }
    const findPumpTrucks = async () => {
      console.log(111)
      const res = await request.get('/pumpTruck/pumptruck/findAllPumpTrucks');
      console.log(res)
      demo.PumpTrucks = res.data
      console.log(demo.PumpTrucks)
      return res
    }
    const findPumpTrucksBypumpTruckNumber = async () =>{
      const res = await request.get('/pumpTruck/pumptruck/findPumpTrucksBypumpTruckNumber/' +demo.searchInput2);
      console.log(res)
      demo.PumpTrucks = res.data
      console.log(demo.PumpTrucks)
      return res
    }
    const findPumpTrucksBypumpTruckid = async () =>{
      const res = await request.get('/pumpTruck/pumptruck/findPumpTrucksBypumpTruckid/' +demo.searchInput1);
      console.log(res)
      demo.PumpTrucks = res.data
      console.log(demo.PumpTrucks)
      return res
    }

    const deleteEvent = async (row) => {
      alert(row.id)
      const res = await request.delete('/pumpTruck/pumptruck/deletePumpTruck/' + row.id)
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
      const res = await request.put('/pumpTruck/pumptruck/updatePumpTruck', data);
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }

    const addPumpTruck = async () => {
      demo.addStatus = true
    }

    const addEvent = async () => {
      demo.addStatus = false
      let data = {
        pumptruckid: demo.addData.pumptruckid,
        pumptrucknumber: demo.addData.pumptrucknumber,
        caridennumber: demo.addData.caridennumber,
        gpsidennumber: demo.addData.gpsidennumber,
        pumpingheight: demo.addData.pumpingheight,
        subunit: demo.addData.subunit,
        personincharge: demo.addData.personincharge,
        remarks: demo.addData.remarks,
        status: demo.addData.status
      }
      console.log(data)
      const res = await request.post('/pumpTruck/pumptruck/addPumpTruck', data)
      console.log(demo.addData)
      if (res.data.code === 0) {
        return res.data.message;
      }
      location.reload()
      return Promise.reject(new Error(res.data.message));
    }

    return {
      demo,
      findPumpTrucks,
      deleteEvent,
      updateEvent,
      submitEvent,
      addPumpTruck,
      addEvent,
      findPumpTrucksBypumpTruckNumber,
      findPumpTrucksBypumpTruckid,
      cellStyle
    }
  },

}

</script>

<style scoped>

</style>
