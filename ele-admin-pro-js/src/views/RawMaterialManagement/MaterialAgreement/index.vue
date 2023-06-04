<template >
  <div>
    <vxe-button status="primary" content="刷新" type="datetime" @click="findAllMA()"></vxe-button>
    <vxe-input v-model="demo.searchInput1" placeholder="采购时间" type="datetime" ></vxe-input>
    <vxe-button status="primary" content="查询" @click="findMAByPtime()"></vxe-button>
    <vxe-input v-model="demo.searchInput2" placeholder="供应商" type="search" ></vxe-input>
    <vxe-button status="primary" content="查询" @click="findMABysupplier()"></vxe-button>
    <vxe-button status="primary" content="新增协议信息" @click="addMA()"></vxe-button>
    <vxe-table
      :data="demo.ma">
      <vxe-column field="purchaseagreementnum" title="协议编号"></vxe-column>
      <vxe-column field="state" title="状态"></vxe-column>
      <vxe-column field="dgntime" title="制定时间"></vxe-column>
      <vxe-column field="correspondenceunit" title="供应商"></vxe-column>
      <vxe-column field="supplymaterials" title="供应原材料"></vxe-column>
      <vxe-column field="procurementtime" title="开始采购时间"></vxe-column>
      <vxe-column field="contacts" title="联系人"></vxe-column>
      <vxe-column field="number" title="联系方式"></vxe-column>
      <vxe-column title="操作" width="180">
        <template #default="{ row }">
          <vxe-button status="warning" content="编辑" @click="updateEvent(row)"></vxe-button>
          <vxe-button status="danger" content="删除" @click="deleteEvent(row)"></vxe-button>
        </template>
      </vxe-column>
    </vxe-table>



    <vxe-modal v-model="demo1.value5" width="600" show-footer>
      <vxe-table
        stripe
        :span-method="colspanMethod"
        :data="rawMaterials">
        <vxe-column type="seq" width="60"></vxe-column>
        <vxe-column field="correspondenceunit" title="单位名称"></vxe-column>
        <vxe-column field="supplyRawMaterials" title="供应原材料"></vxe-column>
        <vxe-column field="platformRawMaterials" title="单位地址"></vxe-column>
        <vxe-column field="contacts" title="联系人"></vxe-column>
        <vxe-column field="number" title="联系方式"></vxe-column>
        <vxe-column field="operate" title="Operate" #default="{ row }">
          <vxe-button type="text" status="danger" content="添加" @click="addCorrespondenceunit(row)"></vxe-button>
        </vxe-column>
      </vxe-table>
    </vxe-modal>



    <!--    &lt;!&ndash;新增弹窗&ndash;&gt;-->

    <!--    `<vxe-modal v-model="demo.addStatus" :title=" '新增协议'" width="800" min-width="600" min-height="300"  resize destroy-on-close>-->
    <!--    <vxe-form :data="demo.addData" title-align="right" title-width="100" >-->
    <!--      <vxe-form-item title="采购协议" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>-->

    <!--&lt;!&ndash;输入框 相当于label和input&ndash;&gt;-->
    <!--      <vxe-form-item field="correspondenceunit" title="往来单位" :span="12" :item-render="{}">-->

    <!--&lt;!&ndash;   v-model 与输入框的值进行绑定    &ndash;&gt;-->
    <!--        <vxe-select v-model="correspondenceunit" :model-value="demo.updateData.correspondenceunit" placeholder="请选择往来单位" @click="selectAllGoods">-->
    <!--          &lt;!&ndash;              <vxe-option :model="demo.updateData.correspondenceunit" :value="correspondenceunit" label="往来单位运输"></vxe-option>&ndash;&gt;-->
    <!--        </vxe-select>-->
    <!--      </vxe-form-item>-->

    <!--      <vxe-form-item field="supplymethod" title="供应方式" :span="12" :item-render="{}">-->
    <!--        <template #default="{ data }">-->
    <!--          <vxe-select v-model="data.supplymethod" placeholder="请选择供应方式">-->
    <!--            <vxe-option :value="'往来单位运输'" label="往来单位运输"></vxe-option>-->
    <!--            <vxe-option :value="'搅拌站运输'" label="搅拌站运输"></vxe-option>-->
    <!--          </vxe-select>-->
    <!--        </template>-->
    <!--      </vxe-form-item>-->

    <!--      <vxe-form-item field="supplymaterials" title="供应原材料" :span="12" :item-render="{}">-->
    <!--        <vxe-input v-model="demo.addData.supplymaterials" placeholder="供应原材料"></vxe-input>-->
    <!--      </vxe-form-item>-->

    <!--      <vxe-form-item field="contacts" title="联系人" :span="12" :item-render="{}">-->
    <!--        <vxe-input v-model="demo.addData.contacts" placeholder="联系人"></vxe-input>-->
    <!--      </vxe-form-item>-->

    <!--      <vxe-form-item field="number" title="联系电话" :span="12" :item-render="{}">-->
    <!--        <vxe-input v-model="demo.addData.number" placeholder="联系电话"></vxe-input>-->
    <!--      </vxe-form-item>-->

    <!--      <vxe-form-item field="deliveryplace" title="单位地址" :span="12" :item-render="{}">-->
    <!--        <vxe-input v-model="demo.addData.deliveryplace" placeholder="单位地址"></vxe-input>-->
    <!--      </vxe-form-item>-->

    <!--      <vxe-form-item field="procurementtime" title="开始采购时间" :span="12" :item-render="{}">-->
    <!--        <vxe-input v-model="demo.addData.procurementtime" placeholder="采购时间" type="datetime"></vxe-input>-->
    <!--      </vxe-form-item>-->


    <!--      <vxe-form-item align="center" title-align="left" :span="24">-->
    <!--        <template #default>-->
    <!--          <vxe-button @click="addEvent">提交</vxe-button>-->
    <!--          <vxe-button type="reset">重置</vxe-button>-->
    <!--        </template>-->
    <!--      </vxe-form-item>-->
    <!--    </vxe-form>-->
    <!--  </vxe-modal>-->



    <vxe-modal v-model="demo.addStatus" :title=" '编辑&保存'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
      <vxe-form :data="demo.addData" title-align="right" title-width="100" >
        <vxe-form-item title="采购协议" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>


        <vxe-form-item field="correspondenceunit" title="往来单位" :span="12" :item-render="{}">

          <vxe-select v-model="correspondenceunit" :model-value="demo.addData.correspondenceunit" placeholder="请选择往来单位" @click="selectAllGoods">
            <!--              <vxe-option :model="demo.updateData.correspondenceunit" :value="correspondenceunit" label="往来单位运输"></vxe-option>-->
          </vxe-select>
        </vxe-form-item>

        <vxe-form-item field="supplymethod" title="供应方式" :span="12" :item-render="{}">
          <!--        <template #default="{ data }">-->
          <vxe-select v-model="demo.addData.supplymethod" placeholder="请选择供应方式">
            <vxe-option :value="'往来单位运输'" label="往来单位运输"></vxe-option>
            <vxe-option :value="'搅拌站运输'" label="搅拌站运输"></vxe-option>
          </vxe-select>
          <!--        </template>-->
        </vxe-form-item>

        <vxe-form-item field="supplymaterials" title="供应原材料" :span="12" :item-render="{}">
          <vxe-input v-model="demo.addData.supplymaterials" placeholder="供应原材料"></vxe-input>
        </vxe-form-item>

        <vxe-form-item field="contacts" title="联系人" :span="12" :item-render="{}">
          <vxe-input v-model="demo.addData.contacts" placeholder="联系人"></vxe-input>
        </vxe-form-item>

        <vxe-form-item field="number" title="联系电话" :span="12" :item-render="{}">
          <vxe-input v-model="demo.addData.number" placeholder="联系电话"></vxe-input>
        </vxe-form-item>

        <vxe-form-item field="deliveryplace" title="单位地址" :span="12" :item-render="{}">
          <vxe-input v-model="demo.addData.deliveryplace" placeholder="单位地址"></vxe-input>
        </vxe-form-item>


        <vxe-form-item field="procurementtime" title="开始采购时间" :span="12" :item-render="{}">
          <vxe-input v-model="demo.addData.procurementtime" placeholder="采购时间" type="datetime"></vxe-input>
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


      <vxe-form-item field="correspondenceunit" title="往来单位" :span="12" :item-render="{}">

        <vxe-select v-model="correspondenceunit" :model-value="demo.updateData.correspondenceunit" placeholder="请选择往来单位" @click="selectAllGoods">
          <!--              <vxe-option :model="demo.updateData.correspondenceunit" :value="correspondenceunit" label="往来单位运输"></vxe-option>-->
        </vxe-select>
      </vxe-form-item>

      <vxe-form-item field="supplymethod" title="供应方式" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.supplymethod" placeholder="请选择供应方式">
            <vxe-option :value="'往来单位运输'" label="往来单位运输"></vxe-option>
            <vxe-option :value="'搅拌站运输'" label="搅拌站运输"></vxe-option>
          </vxe-select>
        </template>
      </vxe-form-item>

      <vxe-form-item field="supplymaterials" title="供应原材料" :span="12" :item-render="{}">
        <vxe-input v-model="demo.updateData.supplymaterials" placeholder="供应原材料"></vxe-input>
      </vxe-form-item>

      <vxe-form-item field="contacts" title="联系人" :span="12" :item-render="{}">
        <vxe-input v-model="demo.updateData.contacts" placeholder="联系人"></vxe-input>
      </vxe-form-item>

      <vxe-form-item field="number" title="联系电话" :span="12" :item-render="{}">
        <vxe-input v-model="demo.updateData.number" placeholder="联系电话"></vxe-input>
      </vxe-form-item>

      <vxe-form-item field="deliveryplace" title="单位地址" :span="12" :item-render="{}">
        <vxe-input v-model="demo.updateData.deliveryplace" placeholder="单位地址"></vxe-input>
      </vxe-form-item>


      <vxe-form-item field="procurementtime" title="开始采购时间" :span="12" :item-render="{}">
        <vxe-input v-model="demo.updateData.procurementtime" placeholder="采购时间" type="datetime"></vxe-input>
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
      findAllMA()
    })
    const demo = reactive({
      ma:[],
      searchInput1:[],
      searchInput2:[],
      projectname: '',
      status: false,
      addData: ref([{correspondenceunit:'',supplymethod:'',contacts:'',number:'',procurementtime:'',deliveryplace:'',procurementTime:''}]),
      addStatus: false,
      updateData: ref([{correspondenceunit:'',supplymethod:'',contacts:'',number:'',procurementtime:'',deliveryplace:'',procurementTime:''}]),

    })

    const demo1 = reactive({
      value5: false,
      supplyId:undefined,

    })

    // let supplyRaws=ref([])


    let rawMaterials = ref([{id: "001",rawMaterialId: "",rrId: 1,correspondenceunit:"供应商1", supplyRawMaterials: "测试1", deliveryplace: "测试2",contacts:'张安',number: 1},
      {id: "002",rawMaterialId: "",rrId: 1,correspondenceunit:"供应商2", supplyRawMaterials: "测试3", deliveryplace: "测试4",contacts:'牛犇',number: 1},
      {id: "003",rawMaterialId: "",rrId: 1,correspondenceunit:"供应商3", supplyRawMaterials: "测试5",  deliveryplace: "测试6",contacts:'黄渤',number: 1}])




    const selectAllGoods=async ()=>{
      demo1.value5 = true
      // const res=await request.delete('/test/student/deleteStudent/'+row.id)
      // const res=await request.get('/work/raw-material-supplier');
      // demo1.supplyId=record.id
      // console.log(res.data.data);
      // rawMaterials.value=res.data.data;
      // console.log(res)
      // return res
    }

    const addCorrespondenceunit=async (row)=>{
      alert(row.supplyRawMaterials);

      demo.updateData.correspondenceunit=row.correspondenceunit;
      demo.updateData.contacts=row.contacts;
      demo.updateData.supplymaterials=row.supplyRawMaterials;
      demo.updateData.number=row.number;
      demo.updateData.deliveryplace=row.deliveryplace;

      demo.addData=demo.updateData
      demo1.value5=false;

    }


    const findAllMA = async () =>{
      console.log(111)
      const res = await request.get('/material/findAllMA');
      console.log(res.data)
      demo.ma = res.data
      return res
    }

    const  findMABysupplier = async () =>{
      console.log(111)
      const res = await request.get('/material/findMABysupplier'+demo.searchInput2);
      console.log(res.data)
      demo.ma = res.data
      return res
    }
    const findMAByPtime = async () =>{
      console.log(111)
      const res = await request.get('/material/findMAByPtime'+demo.searchInput1);
      console.log(res.data)
      demo.ma = res.data
      return res
    }


    const addMA = async () => {
      demo.addStatus = true

    }

    const updateEvent=(row)=>{
      demo.status=true
      demo.updateData=row
    }

    const deleteEvent=async (row) => {
      alert(row.id)
      const res = await request.delete('/material/deleteMaterial/'+row.id)
      if (res.data.code==0){
        return res.data.message
      }
      reload()
      return Promise.reject((new Error(res.data.message)))
    }

    const submitEvent=async () => {
      console.log(demo.updateData)
      demo.status=false
      let data=demo.updateData
      const res = await request.put('/material/updateMaterial',data);
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }



    const addEvent = async () => {
      console.log(demo.updateData)
      console.log(demo.updateData.contacts)


      demo.addStatus = false
      // let data=demo.updateData

      let data = {
        correspondenceunit: demo.addData.correspondenceunit,
        supplymethod: demo.addData.supplymethod,
        procurementtime: demo.addData.procurementtime,
        deliveryplace: demo.addData.deliveryplace,
        supplymaterials: demo.addData.supplymaterials,
        // platformmaterials: demo.addData.platformmaterials,
        // pricingunit: demo.addData.pricingunit,
        // conversioncoefficient: demo.addData.conversioncoefficient,
        // state: demo.addData.state,
        // plannedquantity: demo.addData.plannedquantity,
        // unitprice: demo.addData.unitprice,
        contacts: demo.addData.contacts,
        number:demo.addData.number
      }
      console.log(data)
      const res = await request.put('/material/addMaterial', data)
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }

    return{
      demo,
      // dialogVisible,
      findAllMA,
      deleteEvent,
      updateEvent,
      submitEvent,
      addEvent,
      findMAByPtime,
      findMABysupplier,
      addMA,
      selectAllGoods,
      demo1,
      rawMaterials,
      addCorrespondenceunit
    }
  }
}
</script>




