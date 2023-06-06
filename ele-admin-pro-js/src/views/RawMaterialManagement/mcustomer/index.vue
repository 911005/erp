<template >
  <div>
    <vxe-button status="primary" content="刷新" type="datetime" @click="findAllMcustomer()"></vxe-button>
<!--    <vxe-input v-model="demo.searchInput1" placeholder="采购时间" type="datetime" ></vxe-input>-->
<!--    <vxe-button status="primary" content="查询" @click="findMAByPtime()"></vxe-button>-->
<!--    <vxe-input v-model="demo.searchInput2" placeholder="供应商" type="search" ></vxe-input>-->
<!--    <vxe-button status="primary" content="查询全部客户" @click="findAllMcustomer()"></vxe-button>-->
    <vxe-button status="primary" content="新增协议信息" @click="addMcustomer()"></vxe-button>
    <vxe-table
      height="495"
      :data="demo.ma">
      <vxe-column  type="seq" width="60" field="id" title="编号"></vxe-column>
      <vxe-column field="unitname" title="单位名称"></vxe-column>
      <vxe-column field="unittype" title="单位类型"></vxe-column>
      <vxe-column field="pnumber" title="电话号码"></vxe-column>
      <vxe-column field="address" title="地址"></vxe-column>
      <vxe-column field="operator" title="业务员"></vxe-column>
      <vxe-column field="state" title="状态"></vxe-column>
      <vxe-column field="remarks" title="备注"></vxe-column>
<!--      <vxe-column field="number" title="联系方式"></vxe-column>-->
      <vxe-column title="操作" width="180">
        <template #default="{ row }">
          <vxe-button status="warning" content="编辑" @click="updateEvent(row)"></vxe-button>
          <vxe-button status="danger" content="删除" @click="deleteEvent(row)"></vxe-button>
        </template>
      </vxe-column>
    </vxe-table>


<!--新增窗口-->

    <vxe-modal v-model="demo.addStatus" :title=" '新增客户'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
      <vxe-form :data="demo.addData" title-align="right" title-width="100" >
        <vxe-form-item title="采购协议" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>


        <vxe-form-item field="unitname" title="单位名称" :span="12" :item-render="{}">
          <vxe-input v-model="demo.addData.unitname" placeholder="单位名称"></vxe-input>
        </vxe-form-item>

        <vxe-form-item field="unittype" title="单位类型" :span="12" :item-render="{}">
          <vxe-select v-model="demo.addData.unittype" placeholder="单位类型">
            <vxe-option :value="'原材料客户'" label="原材料客户"></vxe-option>
          </vxe-select>
        </vxe-form-item>

        <vxe-form-item field="pnumber" title="联系电话" :span="12" :item-render="{}">
          <vxe-input v-model="demo.addData.pnumber" placeholder="联系电话"></vxe-input>
        </vxe-form-item>

        <vxe-form-item field="address" title="联系地址" :span="12" :item-render="{}">
          <vxe-input v-model="demo.addData.address" placeholder="联系人"></vxe-input>
        </vxe-form-item>

        <vxe-form-item field="operator" title="业务员" :span="12" :item-render="{}">
          <vxe-input v-model="demo.addData.operator" placeholder="业务员"></vxe-input>
        </vxe-form-item>

        <vxe-form-item field="state" title="状态" :span="12" :item-render="{}">
          <vxe-input v-model="demo.addData.state" placeholder="状态"></vxe-input>
        </vxe-form-item>

        <vxe-form-item field="remarks" title="备注" :span="12" :item-render="{}">
          <vxe-input v-model="demo.addData.remarks" placeholder="备注" ></vxe-input>
        </vxe-form-item>

        <vxe-form-item align="center" title-align="left" :span="24">
          <template #default>
            <vxe-button @click="addEvent">提交</vxe-button>
            <vxe-button type="reset">重置</vxe-button>
          </template>
        </vxe-form-item>
      </vxe-form>
    </vxe-modal>




    <!--  编辑弹窗-->
    <!--    status 默认false 窗口是否显示-->
    <!--    表单输入项绑定到data里 -->
    `<vxe-modal v-model="demo.status" :title=" '编辑&保存'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
    <vxe-form :data="demo.updateData" title-align="right" title-width="100" >
      <vxe-form-item title="采购协议" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>


      <vxe-form-item field="unitname" title="单位名称" :span="12" :item-render="{}">
        <vxe-input v-model="demo.updateData.unitname" placeholder="单位名称"></vxe-input>
      </vxe-form-item>

      <vxe-form-item field="unittype" title="单位类型" :span="12" :item-render="{}">
        <vxe-select v-model="demo.updateData.unittype" placeholder="单位类型">
          <vxe-option :value="'原材料客户'" label="原材料客户"></vxe-option>
        </vxe-select>
      </vxe-form-item>

      <vxe-form-item field="pnumber" title="联系电话" :span="12" :item-render="{}">
        <vxe-input v-model="demo.updateData.pnumber" placeholder="联系电话"></vxe-input>
      </vxe-form-item>

      <vxe-form-item field="address" title="联系地址" :span="12" :item-render="{}">
        <vxe-input v-model="demo.updateData.address" placeholder="联系人"></vxe-input>
      </vxe-form-item>

      <vxe-form-item field="operator" title="业务员" :span="12" :item-render="{}">
        <vxe-input v-model="demo.updateData.operator" placeholder="业务员"></vxe-input>
      </vxe-form-item>

      <vxe-form-item field="state" title="状态" :span="12" :item-render="{}">
        <vxe-input v-model="demo.updateData.state" placeholder="状态"></vxe-input>
      </vxe-form-item>


      <vxe-form-item field="remarks" title="备注" :span="12" :item-render="{}">
        <vxe-input v-model="demo.updateData.remarks" placeholder="备注" ></vxe-input>
      </vxe-form-item>

      <vxe-form-item align="center" title-align="left" :span="24">
        <template #default>
          <vxe-button @click="submitEvent">提交</vxe-button>
          <vxe-button type="reset">重置</vxe-button>
        </template>
      </vxe-form-item>
    </vxe-form>
  </vxe-modal>



  </div>
</template>

<script>
import {reactive, onMounted, ref} from "vue";
import request from "@/utils/request";


export default {

  name: "index",
  setup(){
    onMounted(() => {
      findAllMcustomer()
    })
    const demo = reactive({
      ma:[],
      // searchInput1:[],
      // searchInput2:[],
      projectname: '',
      status: false,
      addData: [],
      addStatus: false,
      updateData: []
      //ref([{correspondenceunit:'',supplymethod:'',contacts:'',number:'',procurementtime:'',deliveryplace:'',procurementTime:''}]),

    })


    const findAllMcustomer = async () =>{
      console.log(111)
      const res = await request.get('/mcustomer/findAllMcustomer');
      console.log(res.data)
      demo.ma = res.data
      return res
    }

    // const  findMABysupplier = async () =>{
    //   console.log(111)
    //   const res = await request.get('/material/findMABysupplier'+demo.searchInput2);
    //   console.log(res.data)
    //   demo.ma = res.data
    //   return res
    // }
    // const findMAByPtime = async () =>{
    //   console.log(111)
    //   const res = await request.get('/material/findMAByPtime'+demo.searchInput1);
    //   console.log(res.data)
    //   demo.ma = res.data
    //   return res
    // }


    const addMcustomer = async () => {
      demo.addStatus = true

    }

    const updateEvent=(row)=>{
      demo.status=true
      demo.updateData=row
    }

    const deleteEvent = async (row) => {
      alert(row.id)

      const res = await request.delete('/mcustomer/deleteMcustomer/' + row.id)
      if (res.data.code == 0) {
        return res.data.message
      }
      reload()
      return Promise.reject((new Error(res.data.message)))
    }


    const submitEvent=async () => {
      console.log(demo.updateData)
      demo.status=false
      let data=demo.updateData
      const res = await request.put('/mcustomer/updateMcustomer',data);
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }



    const addEvent = async () => {
      console.log(demo.updateData)
      demo.addStatus = false
      let data = {
        unitname: demo.addData.unitname,
        unittype: demo.addData.unittype,
        pnumber: demo.addData.pnumber,
        address: demo.addData.address,
        operator: demo.addData.operator,
        state: demo.addData.state,
        remarks:demo.addData.remarks
      }
      console.log(data)
      const res = await request.put('/mcustomer/addMcustomer', data)
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }

    return{
      demo,
      findAllMcustomer,
      deleteEvent,
      updateEvent,
      submitEvent,
      addEvent,
      // findMAByPtime,
      // findMABysupplier,
      addMcustomer,
      // selectAllGoods,
      // demo1,
      // rawMaterials,
    }
  }
}
</script>




