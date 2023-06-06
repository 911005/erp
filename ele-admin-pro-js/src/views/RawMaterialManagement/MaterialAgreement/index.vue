<template >
  <div>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <vxe-input v-model="demo.searchInput1" placeholder="采购时间" type="datetime" ></vxe-input>
    <vxe-button status="primary" content="查询" @click="findMAByPtime()"></vxe-button>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <vxe-input v-model="demo.searchInput2" placeholder="供应商" type="search" ></vxe-input>
    <vxe-button status="primary" content="查询" @click="findMABysupplier()"></vxe-button>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <vxe-button status="primary" content="刷新" type="datetime" @click="findAllMA()"></vxe-button>
    <vxe-button status="primary" content="新增" @click="addMA()"></vxe-button>


<!--    底层table-->
    <vxe-table
      height="595"
      :data="demo.ma">
      <vxe-column type="seq" width="60" field="id" title="编号"></vxe-column>
      <vxe-column field="purchaseagreementnum" title="协议编号"></vxe-column>
      <vxe-column field="state" title="状态"></vxe-column>
      <vxe-column field="supplymethod" title="运输方式"></vxe-column>
      <vxe-column field="correspondenceunit" title="供应商"></vxe-column>
<!--      <vxe-column field="supplymaterials" title="供应原材料"></vxe-column>-->
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


<!--弹出窗口-->
    <vxe-modal v-model="demo1.value5" width="600" show-footer>
      <vxe-table
        stripe
        :span-method="colspanMethod"
        :data="suppliers">
        <vxe-column type="seq" width="60"></vxe-column>

        <vxe-column field="suppliername" title="单位名称"></vxe-column>
        <vxe-column field="supplieraddress" title="单位地址"></vxe-column>
        <vxe-column field="saleman" title="联系人"></vxe-column>
        <vxe-column field="phone" title="联系方式"></vxe-column>
        <vxe-column field="operate" title="Operate" #default="{ row }" >
<!--          <vxe-button type="text" status="danger" content="添加"  @click="findSMById(row)" ></vxe-button>-->
<!--          <vxe-button type="text" status="danger" content="添加" @click="addSuppliers(row) "></vxe-button>-->
          <vxe-button type="text" status="danger" content="提交"  @click="addSuppliers(row)" ></vxe-button>
        </vxe-column>
      </vxe-table>



    </vxe-modal>




<!--新增窗口-->
    <vxe-modal v-model="demo.addStatus" :title=" '新增'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
      <vxe-form :data="demo.addData" title-align="right" title-width="100" >
        <vxe-form-item title="采购协议" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>

        <vxe-form-item field="purchaseagreementnum" title="订单编号" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.purchaseagreementnum" placeholder="订单编号" disabled></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="state" title="状态" :span="12" :item-render="{}">
          <vxe-select v-model="demo.updateData.state" placeholder="状态">
            <vxe-option :value="'启用'" label="启用"></vxe-option>
            <vxe-option :value="'禁用'" label="禁用"></vxe-option>
          </vxe-select>
        </vxe-form-item>


        <vxe-form-item field="correspondenceunit" title="供应商单位" :span="12" :item-render="{}">

          <vxe-select v-model="correspondenceunit" :model-value="demo.addData.correspondenceunit" placeholder="请选择供应商单位" @click="selectAllGoods">
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

        <!--        传------------------>

<!--                <vxe-form-item field="supplymaterials" title="供应原材料" :span="12" :item-render="{}">-->
<!--          <vxe-input v-model="demo.addData.supplymaterials" placeholder="供应原材料"></vxe-input>-->
<!--        </vxe-form-item>-->

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

<!-- ----------------------------------------- 原材料价格-------------------------------------------------->
        <vxe-form-item title="原材料价格" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>

        <vxe-form-item field="supplymaterials" title="供应原材料" :span="12" :item-render="{}">
          <vxe-input v-model="demo.addData.supplymaterials" placeholder="供应原材料" ></vxe-input>
        </vxe-form-item>

        <vxe-form-item field="platformmaterials" title="平台原材料" :span="12" :item-render="{}">
          <vxe-input v-model="demo.addData.platformmaterials" placeholder="平台原材料" ></vxe-input>
        </vxe-form-item>

        <vxe-form-item field="pricingunit" title="计价单位" :span="12" :item-render="{}">
            <vxe-select v-model="demo.addData.pricingunit" placeholder="请选择供应方式">
              <vxe-option :value="'吨'" label="吨"></vxe-option>
            </vxe-select>
        </vxe-form-item>

        <vxe-form-item field="plannedquantity" title="计划数量" :span="12" :item-render="{}">
          <vxe-input v-model="demo.addData.plannedquantity" placeholder="请输入计划数量" type="integer" ></vxe-input>
        </vxe-form-item>

        <vxe-form-item field="unitprice" title="单价" :span="12" :item-render="{}">
          <vxe-input v-model="demo.addData.unitprice" placeholder="输入单价"  type="integer"></vxe-input>
        </vxe-form-item>


        <!-- ----------------------------------------- 原材料价格-------------------------------------------------->

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
    `<vxe-modal v-model="demo.status" :title=" '编辑'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
    <vxe-form :data="demo.updateData" title-align="right" title-width="100" >
      <vxe-form-item title="采购协议" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>

      <vxe-form-item field="purchaseagreementnum" title="订单编号" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.purchaseagreementnum" placeholder="订单编号" disabled></vxe-input>
        </template>
      </vxe-form-item>
      <vxe-form-item field="state" title="状态" :span="12" :item-render="{}">
        <vxe-select v-model="demo.updateData.state" placeholder="状态">
          <vxe-option :value="'启用'" label="启用"></vxe-option>
          <vxe-option :value="'禁用'" label="禁用"></vxe-option>
        </vxe-select>
      </vxe-form-item>

      <vxe-form-item field="correspondenceunit" title="供应商" :span="12" :item-render="{}">

        <vxe-select v-model="correspondenceunit" :model-value="demo.updateData.correspondenceunit" placeholder="请选择供应商" @click="selectAllGoods">
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

      <!--        传------------------>

      <!--      <vxe-form-item field="supplymaterials" title="供应原材料" :span="12" :item-render="{}">-->
<!--        <vxe-input v-model="demo.updateData.supplymaterials" placeholder="供应原材料"></vxe-input>-->
<!--      </vxe-form-item>-->

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

<!-------------------------------------------------------------------------------------------------------->
      <vxe-form-item title="原材料价格" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>

      <vxe-form-item field="supplymaterials" title="供应原材料" :span="12" :item-render="{}">
        <vxe-input v-model="demo.updateData.supplymaterials" placeholder="供应原材料" ></vxe-input>
      </vxe-form-item>

      <vxe-form-item field="platformmaterials" title="平台原材料" :span="12" :item-render="{}">
        <vxe-input v-model="demo.updateData.platformmaterials" placeholder="平台原材料" ></vxe-input>
      </vxe-form-item>

      <vxe-form-item field="pricingunit" title="计价单位" :span="12" :item-render="{}">
        <vxe-select v-model="demo.updateData.pricingunit" placeholder="计价单位">
          <vxe-option :value="'吨'" label="吨"></vxe-option>
        </vxe-select>
      </vxe-form-item>

      <vxe-form-item field="plannedquantity" title="计划数量" :span="12" :item-render="{}">
        <vxe-input v-model="demo.updateData.plannedquantity" placeholder="请输入计划数量" type="integer" ></vxe-input>
      </vxe-form-item>

      <vxe-form-item field="unitprice" title="单价" :span="12" :item-render="{}">
        <vxe-input v-model="demo.updateData.unitprice" placeholder="输入单价"  type="integer"></vxe-input>
      </vxe-form-item>

<!--      -------------------------------------------------------------------------------------------------->

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
      generateNumber()
      findSupplisers()
      // findSMById()
    })

    const savedCounter = localStorage.getItem("counter"); // 从本地存储中获取上次使用的计数器值

    const demo = reactive({
      counter: savedCounter ? Number(savedCounter) : 0, // 如果存在保存的计数器值，则使用它；否则初始化为 0
      purchaseagreementnum:'',
      ma:[],
      smid:ref(123),
      // sm:ref([{supplymaterialname:'',platformmaterialname:''}]),
      searchInput1:[],
      searchInput2:[],
      projectname: '',
      supplymaterialname:'',
      status: false,
      addData: ref([{purchaseagreementnum:'',state:'', correspondenceunit:'',supplymethod:'',contacts:'',number:'',procurementtime:'',deliveryplace:'',procurementTime:'',
        platformmaterials:'' }]),
      addStatus: false,
      updateData: ref([{state:'',correspondenceunit:'',supplymethod:'',contacts:'',number:'',procurementtime:'',deliveryplace:'',procurementTime:'',supplymaterialname:'zzzzz'}]),
    })

    const demo1 = reactive({
      value5: false,
      supplyId:undefined,

    })

    //弹窗
    // let supplyRaws=ref([])
    const suppliers=ref([]);


    const findSupplisers = async () => {
      console.log(567)
      const res = await request.get('/supplier/supplier/findAllSuppliers');
      console.log("res",res)
      suppliers.value = res.data
      return res
    }



    //增加供应商
    const selectAllGoods=async ()=>{
      demo1.value5 = true

    }

    let dd=ref([{supplymaterialname:'',platformmaterialname:''}]);

    const addSuppliers=async (row)=>{

      demo.smid=row.materialid;

      try {
        const res2 = await request.get('/test1/SupplyMaterials/findSMById/' + demo.smid);
        dd.value = res2.data.map(item => ({ supplymaterialname: item.supplymaterialname, platformmaterialname: item.platformmaterialname }));

        // alert(JSON.stringify(dd))

        console.log('*****************************.....................................................')
        console.log(dd)

        const supplymaterials = dd.value.map(item => item.supplymaterialname).join(",");
        const platformmaterials=dd.value.map(item => item.platformmaterialname).join(",");

        demo.updateData.platformmaterials=platformmaterials;
        demo.updateData.supplymaterials = supplymaterials; // 将 supplymaterials 赋值为一个字符串类型
        console.log('*****************************.....................................................')
        console.log( demo.updateData.platformmaterialname)
        console.log('...************************************..................................................')
        console.log(demo.updateData.supplymaterials)
        console.log('...************************************..................................................')
      } catch (error) {
        console.error(error); // 打印出接口错误信息
      }

      demo.updateData.correspondenceunit=row.suppliername;
      demo.updateData.deliveryplace=row.supplieraddress;
      demo.updateData.contacts=row.saleman;
      demo.updateData.number=row.phone;
      console.log('.....................................................')
      console.log(demo.updateData.supplymaterials)
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
      await generateNumber()
      demo.addData.purchaseagreementnum=demo.purchaseagreementnum
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
        purchaseagreementnum:demo.addData.purchaseagreementnum,
        state:demo.addData.state,
        correspondenceunit: demo.addData.correspondenceunit,
        supplymethod: demo.addData.supplymethod,
        procurementtime: demo.addData.procurementtime,
        deliveryplace: demo.addData.deliveryplace,
        supplymaterials: demo.addData.supplymaterials,
        platformmaterials:demo.addData.platformmaterials,
        contacts: demo.addData.contacts,
        number:demo.addData.number,
        pricingunit:demo.addData.pricingunit,
        plannedquantity:demo.addData.plannedquantity,
        unitprice:demo.addData.unitprice
      }

      alert(data.purchaseagreementnum)
      console.log('..............................................................')
      console.log(data)
      const res = await request.put('/material/addMaterial', data)
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }


    //生成特定的编号
    const generateNumber=async () => {
      const first="XY";
      const now = new Date();
      const year = now.getFullYear().toString().substr(2);
      const month = `0${now.getMonth() + 1}`.slice(-2);
      const day = `0${now.getDate()}`.slice(-2);
      const counterStr = `00${++demo.counter}`.slice(-3); // 计数器自增，并将其转换为带前导零的三位数
      const number = `${first}${year}${month}${day}${counterStr}`; // 将前缀、当前日期和计数器拼接成字符串，并赋值给 generatedString 变量
      demo.purchaseagreementnum=number;
      localStorage.setItem("counter",demo.counter);
      return number
    }

    return{
      demo,
      demo1,
      suppliers,
      // dialogVisible,
      generateNumber,
      findSupplisers,
      findAllMA,
      deleteEvent,
      updateEvent,
      submitEvent,
      addEvent,
      findMAByPtime,
      findMABysupplier,
      addMA,
      selectAllGoods,
      // findSMById,
      addSuppliers
    }
  }
}
</script>




