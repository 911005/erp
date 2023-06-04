<template>
<div>
  <vxe-input v-model="demo.searchInput1" placeholder="输入任务编号" type="search" ></vxe-input>
  <vxe-button status="primary" content="查询" @click="findProductionTasksByMnumber()"></vxe-button>
  <vxe-button status="primary" content="查询所有任务信息" @click="findProductiontasks()"></vxe-button>
  <vxe-button status="primary" content="新增生产任务信息" @click="addProductiontasks()"></vxe-button>
  <vxe-table
    height="495"
    :data="demo.productionTasks">
    <vxe-column type="seq" width="60" field="missonid" title="序号"></vxe-column>
    <vxe-column field="mnumber" title="任务编号"></vxe-column>
    <vxe-column field="mstatus" title="状态"></vxe-column>
    <vxe-column field="pouringdate" title="计划浇筑时间"></vxe-column>
    <vxe-column field="shipmentprogress" title="发货进度"></vxe-column>
    <vxe-column field="customername" title="客户名称"></vxe-column>
    <vxe-column field="projectname" title="工程名称"></vxe-column>
    <vxe-column field="projectaddress" title="施工地址"></vxe-column>
    <vxe-column field="concretemarkings" title="混凝土标记"></vxe-column>
    <vxe-column field="pouringmethod" title="浇筑方式"></vxe-column>
    <vxe-column field="plannedsqueravolume" title="计划方量"></vxe-column>
    <vxe-column field="ordertime" title="制单时间"></vxe-column>
    <vxe-column field="salesman" title="业务员"></vxe-column>
    <vxe-column title="操作" width="180">
      <template #default="{ row }">
        <vxe-button v-if="row.mstatus!=='执行中'" status="warning" content="编辑" @click="updateEvent(row)"></vxe-button>
        <vxe-button v-if="row.mstatus==='制单'" status="danger" icon="vxe-icon-delete" @click="deleteEvent(row)"></vxe-button>
      </template>
    </vxe-column>
  </vxe-table>

  <!--    弹窗-->
  <vxe-modal v-model="demo.value5" width="800" show-footer>
    <vxe-table
      stripe
      height="495"
      :span-method="colspanMethod"
      :data="orders1">
      <vxe-column type="seq" width="60" field="id" title="编号"></vxe-column>
      <vxe-column field="ordernumber" title="订单编号"></vxe-column>
      <vxe-column field="orderdate" title="订货日期"></vxe-column>
      <vxe-column field="pouringdate" title="计划浇筑时间"></vxe-column>
      <vxe-column field="concretemarkings" title="混凝土标记"></vxe-column>
      <vxe-column field="pouringmethod" title="浇筑方式"></vxe-column>
      <vxe-column field="customername" title="客户名称"></vxe-column>
      <vxe-column field="projectname" title="工程名称"></vxe-column>
      <vxe-column field="projectaddress" title="施工地址"></vxe-column>
      <vxe-column field="plannedsqueravolume" title="计划方量"></vxe-column>
      <vxe-column field="operate" title="Operate" #default="{ row }">
        <vxe-button type="text" status="danger" content="添加" @click="addOrderNumber(row)"></vxe-button>
      </vxe-column>
    </vxe-table>
  </vxe-modal>

  <!--  编辑弹窗-->
  <vxe-modal v-model.sync="demo.status" :title=" '编辑&保存'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
    <vxe-form :data="demo.updateData" title-align="right" title-width="100" >
      <vxe-form-item title="生产任务单" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>

      <vxe-form-item field="mnumber" title="编号" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.mnumber" placeholder="任务编号" disabled></vxe-input>
        </template>
      </vxe-form-item>

      <vxe-form-item field="ordertime" title="制单时间" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.ordertime" placeholder="制单时间" type="datetime"></vxe-input>
        </template>
      </vxe-form-item>

      <vxe-form-item field="ordernumber" title="销售订单" :span="8" :item-render="{}">
        <template #default="{ data }">
<!--          <vxe-select v-model="data.orderid" :options="demo.orders" placeholder="销售订单" ></vxe-select>-->
          <vxe-select v-model="demo.updateData.orderid" :model-value="demo.updateData.ordernumber" placeholder="销售订单" @click="selectAllOrders"></vxe-select>
        </template>
      </vxe-form-item>

      <vxe-form-item field="tasklevel" title="任务级别" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.tasklevel" placeholder="请选择">
            <vxe-option :value="'普通'" label="普通"></vxe-option>
            <vxe-option :value="'加急'" label="加急"></vxe-option>
            <vxe-option :value="'特急'" label="特急"></vxe-option>
          </vxe-select>
        </template>
      </vxe-form-item>

      <vxe-form-item field="opensettings" title="开盘设定" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.opensettings" placeholder="请选择">
            <vxe-option :value="'手动开盘'" label="手动开盘"></vxe-option>
            <vxe-option :value="'首车开盘'" label="首车开盘"></vxe-option>
            <vxe-option :value="'每日开盘'" label="每日开盘"></vxe-option>
            <vxe-option :value="'配合比更改开盘'" label="配合比更改开盘"></vxe-option>
          </vxe-select>
        </template>
      </vxe-form-item>

      <vxe-form-item title="混凝土标记" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
      <vxe-form-item field="strengthlevel" title="强度等级" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.strengthlevel" :options="demo.options1" placeholder="强度等级"></vxe-select>
        </template>
      </vxe-form-item>
      <vxe-form-item field="slump" title="坍落度" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.slump" :options="demo.options2" placeholder="坍落度"></vxe-select>
        </template>
      </vxe-form-item>
      <vxe-form-item field="impermeabilitylevel" title="抗渗等级" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.impermeabilitylevel" :options="demo.options3" placeholder="抗渗等级"></vxe-select>
        </template>
      </vxe-form-item>
      <vxe-form-item field="frostresistancelevel" title="抗冻等级" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.frostresistancelevel" :options="demo.options4" placeholder="抗冻等级"></vxe-select>
        </template>
      </vxe-form-item>
      <vxe-form-item field="sulfateresistancelevel" title="抗硫酸盐等级" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.sulfateresistancelevel" :options="demo.options5" placeholder="抗硫酸盐等级"></vxe-select>
        </template>
      </vxe-form-item>
      <vxe-form-item field="chlorideionresistancelevel" title="抗氯离子等级" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.chlorideionresistancelevel" :options="demo.options6" placeholder="抗氯离子等级"></vxe-select>
        </template>
      </vxe-form-item>
      <vxe-form-item field="admixture" title="特殊原材料" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.admixture" :options="demo.options7" placeholder="特殊原材料"></vxe-select>
        </template>
      </vxe-form-item>
      <vxe-form-item field="specialrawmaterials" title="外加剂" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.specialrawmaterials" :options="demo.options8" placeholder="外加剂"></vxe-select>
        </template>
      </vxe-form-item>

      <vxe-form-item title="发货计划" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
      <vxe-form-item field="pouringdate" title="计划浇筑时间" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.pouringdate" placeholder="计划浇筑时间" type="datetime">
          </vxe-select>
        </template>
      </vxe-form-item>
      <vxe-form-item field="plannedsqueravolume" title="计划方量" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.plannedsqueravolume" placeholder="计划方量" type="integer">
          </vxe-select>
        </template>
      </vxe-form-item>

      <vxe-form-item field="shipmentprogress" title="发货进度" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.shipmentprogress" placeholder="发货进度" ></vxe-input>
        </template>
      </vxe-form-item>
      <vxe-form-item field="remarks" title="任务备注" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.remarks" placeholder="任务备注"></vxe-input>
        </template>
      </vxe-form-item>

      <vxe-form-item field="salesman" title="业务员" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.salesman" placeholder="业务员"></vxe-input>
        </template>
      </vxe-form-item>

      <vxe-form-item align="center" title-align="left" :span="24">
        <template #default>
          <vxe-button @click="saveEvent">保存</vxe-button>
          <vxe-button @click="submitEvent">提交</vxe-button>
          <vxe-button type="reset">重置</vxe-button>
        </template>
      </vxe-form-item>
    </vxe-form>
  </vxe-modal>




  <!--  新增弹窗-->
  <vxe-modal v-model.sync="demo.addStatus" :title=" '新增&保存'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
    <vxe-form :data="demo.addData" title-align="right" title-width="100" >
      <vxe-form-item title="生产任务单" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>

      <vxe-form-item field="mnumber" title="编号" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.mnumber" placeholder="任务编号" ></vxe-input>
        </template>
      </vxe-form-item>

      <vxe-form-item field="ordertime" title="制单时间" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.ordertime" placeholder="制单时间" type="datetime"></vxe-input>
        </template>
      </vxe-form-item>

      <vxe-form-item field="orderid" title="销售订单" :span="8" :item-render="{}">
        <template #default="{ data }">
<!--          <vxe-select v-model="data.orderid" :options="demo.orders" placeholder="销售订单" ></vxe-select>-->
          <vxe-select v-model="demo.addData.orderid" :model-value="demo.addData.ordernumber" placeholder="销售订单" @click="selectAllOrders"></vxe-select>
        </template>
      </vxe-form-item>

      <vxe-form-item field="tasklevel" title="任务级别" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.tasklevel" placeholder="请选择">
            <vxe-option :value="'普通'" label="普通"></vxe-option>
            <vxe-option :value="'加急'" label="加急"></vxe-option>
            <vxe-option :value="'特急'" label="特急"></vxe-option>
          </vxe-select>
        </template>
      </vxe-form-item>

      <vxe-form-item field="opensettings" title="开盘设定" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.opensettings" placeholder="请选择">
            <vxe-option :value="'手动开盘'" label="手动开盘"></vxe-option>
            <vxe-option :value="'首车开盘'" label="首车开盘"></vxe-option>
            <vxe-option :value="'每日开盘'" label="每日开盘"></vxe-option>
            <vxe-option :value="'配合比更改开盘'" label="配合比更改开盘"></vxe-option>
          </vxe-select>
        </template>
      </vxe-form-item>

      <vxe-form-item title="混凝土标记" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
      <vxe-form-item field="strengthlevel" title="强度等级" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.strengthlevel" :options="demo.options1" placeholder="强度等级"></vxe-select>
        </template>
      </vxe-form-item>
      <vxe-form-item field="slump" title="坍落度" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.slump" :options="demo.options2" placeholder="坍落度"></vxe-select>
        </template>
      </vxe-form-item>
      <vxe-form-item field="impermeabilitylevel" title="抗渗等级" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.impermeabilitylevel" :options="demo.options3" placeholder="抗渗等级"></vxe-select>
        </template>
      </vxe-form-item>
      <vxe-form-item field="frostresistancelevel" title="抗冻等级" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.frostresistancelevel" :options="demo.options4" placeholder="抗冻等级"></vxe-select>
        </template>
      </vxe-form-item>
      <vxe-form-item field="sulfateresistancelevel" title="抗硫酸盐等级" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.sulfateresistancelevel" :options="demo.options5" placeholder="抗硫酸盐等级"></vxe-select>
        </template>
      </vxe-form-item>
      <vxe-form-item field="chlorideionresistancelevel" title="抗氯离子等级" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.chlorideionresistancelevel" :options="demo.options6" placeholder="抗氯离子等级"></vxe-select>
        </template>
      </vxe-form-item>
      <vxe-form-item field="admixture" title="特殊原材料" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.admixture" :options="demo.options7" placeholder="特殊原材料"></vxe-select>
        </template>
      </vxe-form-item>
      <vxe-form-item field="specialrawmaterials" title="外加剂" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.specialrawmaterials" :options="demo.options8" placeholder="外加剂"></vxe-select>
        </template>
      </vxe-form-item>

      <vxe-form-item title="发货计划" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
      <vxe-form-item field="pouringdate" title="计划浇筑时间" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.pouringdate" placeholder="计划浇筑时间" type="datetime">
          </vxe-select>
        </template>
      </vxe-form-item>
      <vxe-form-item field="plannedsqueravolume" title="计划方量" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-select v-model="data.plannedsqueravolume" placeholder="计划方量" type="integer">
          </vxe-select>
        </template>
      </vxe-form-item>

      <vxe-form-item field="shipmentprogress" title="发货进度" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.shipmentprogress" placeholder="发货进度" ></vxe-input>
        </template>
      </vxe-form-item>
      <vxe-form-item field="remarks" title="任务备注" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.remarks" placeholder="任务备注"></vxe-input>
        </template>
      </vxe-form-item>

      <vxe-form-item field="salesman" title="业务员" :span="8" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.salesman" placeholder="业务员"></vxe-input>
        </template>
      </vxe-form-item>

      <vxe-form-item align="center" title-align="left" :span="24">
        <template #default>
          <vxe-button @click="saveEvent1">保存</vxe-button>
          <vxe-button @click="addEvent">提交</vxe-button>
          <vxe-button type="reset">重置</vxe-button>
        </template>
      </vxe-form-item>
    </vxe-form>
  </vxe-modal>

</div>
</template>

<script>
import {onMounted, reactive, ref} from "vue";
import request from "@/utils/request";

export default {
  name: "index",
  setup(){
    onMounted(() => {
      findProductiontasks()
      findOrders()
      generateNumber()
    })
    const savedCounter = localStorage.getItem("counter"); // 从本地存储中获取上次使用的计数器值
    const demo = reactive({
      value5: false,
      counter: savedCounter ? Number(savedCounter) : 0, // 如果存在保存的计数器值，则使用它；否则初始化为 0
      mnumber:'',
      orderid:'',
      ordernumber:'',
      productionTasks:[],
      status: false,
      addStatus: false,
      // updateData: [],
      searchInput1: [],
      addData: {
        mnumber:'',
        shipmentprogress:'',
        ordertime:'',
        tasklevel:'',
        opensettings:'',
        remarks:'',
        salesman:'',
        orderid:'',
        ordernumber:'',
        strengthlevel:'',
        slump:'',
        impermeabilitylevel:'',
        frostresistancelevel:'',
        sulfateresistancelevel:'',
        chlorideionresistancelevel:'',
        admixture:'',
        specialrawmaterials:'',
        plannedsqueravolume:'',
        pouringdate:'',
      },
      orders: [],
      updateData:{
        mnumber:'',
        shipmentprogress:'',
        ordertime:'',
        tasklevel:'',
        opensettings:'',
        remarks:'',
        salesman:'',
        orderid:'',
        ordernumber:'',
        strengthlevel:'',
        slump:'',
        impermeabilitylevel:'',
        frostresistancelevel:'',
        sulfateresistancelevel:'',
        chlorideionresistancelevel:'',
        admixture:'',
        specialrawmaterials:'',
        plannedsqueravolume:'',
        pouringdate:'',
      }

    })
    const orders1 = ref([]);

    const selectAllOrders=async () =>{
      demo.value5 = true
    }
    const addOrderNumber=async (row)=>{
      demo.addData.orderid=row.id;
      demo.addData.ordernumber=row.ordernumber;
      demo.addData.strengthlevel=row.strengthlevel;
      demo.addData.slump=row.slump;
      demo.addData.impermeabilitylevel=row.impermeabilitylevel;
      demo.addData.frostresistancelevel=row.frostresistancelevel;
      demo.addData.sulfateresistancelevel=row.sulfateresistancelevel;
      demo.addData.chlorideionresistancelevel=row.chlorideionresistancelevel;
      demo.addData.admixture=row.admixture;
      demo.addData.specialrawmaterials=row.specialrawmaterials;
      demo.addData.plannedsqueravolume=row.plannedsqueravolume;
      demo.addData.pouringdate=row.pouringdate;
      // alert(row.supplyRawMaterials);
      demo.updateData.orderid=row.id;
      demo.updateData.ordernumber=row.ordernumber;
      demo.updateData.strengthlevel=row.strengthlevel;
      demo.updateData.slump=row.slump;
      demo.updateData.impermeabilitylevel=row.impermeabilitylevel;
      demo.updateData.frostresistancelevel=row.frostresistancelevel;
      demo.updateData.sulfateresistancelevel=row.sulfateresistancelevel;
      demo.updateData.chlorideionresistancelevel=row.chlorideionresistancelevel;
      demo.updateData.admixture=row.admixture;
      demo.updateData.specialrawmaterials=row.specialrawmaterials;
      demo.updateData.plannedsqueravolume=row.plannedsqueravolume;
      demo.updateData.pouringdate=row.pouringdate;


      demo.value5=false;
    }
    const findOrders = async () => {
      console.log(111)
      const res = await request.get('/order/order/findAllOrders');
      console.log(res)
      orders1.value = res.data
      return res
    }
    const findProductiontasks = async () =>{
      console.log(111)
      const res = await request.get('/productiontask/productiontasks/findAllProductiontasks');
      console.log(res)
      demo.productionTasks = res.data
      console.log(demo.productionTasks)
      return res
    }
    // const findOrders = async () => {
    //   console.log(111)
    //   const res = await request.get('/order/order/findAllOrders');
    //   const data=res.data
    //   if(data && data.length>0){
    //     demo.orders = data.map(item=>{
    //       return {value: item.id, label: item.ordernumber}
    //     });
    //   }
    //   return res
    // }
    const findProductionTasksByMnumber = async () =>{
      const res = await request.get('/productiontask/productiontasks/findProductionTasksByMnumber/' + demo.searchInput1);
      console.log(res)
      demo.productionTasks = res.data
      console.log(demo.productionTasks)
      return res
    }

    const updateEvent=(row)=>{
      demo.status=true
      demo.updateData=row
    }

    const submitEvent=async () => {
      console.log(demo.updateData)
      demo.status = false
      let data = demo.updateData
      data.mstatus = "执行中"
      const res = await request.put('/productiontask/productiontasks/updateProductiontasks', data);
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));

    }
    const saveEvent = async() => {
      demo.status=false
      let data=demo.updateData
      data.mstatus = "制单"
      const res = await request.put('/productiontask/productiontasks/updateProductiontasks',data);
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }
    const addProductiontasks = async () => {
      demo.addStatus = true
      await generateNumber()
      demo.addData.mnumber=demo.mnumber
    }
    //自动生成编号
    const generateNumber=async () => {
      const first="RF";
      const now = new Date();
      const year = now.getFullYear().toString().substr(2);
      const month = `0${now.getMonth() + 1}`.slice(-2);
      const day = `0${now.getDate()}`.slice(-2);
      const counterStr = `00${++demo.counter}`.slice(-3); // 计数器自增，并将其转换为带前导零的三位数
      const number = `${first}${year}${month}${day}${counterStr}`; // 将前缀、当前日期和计数器拼接成字符串，并赋值给 generatedString 变量
      demo.mnumber=number;
      localStorage.setItem("counter",demo.counter);
      return number
    }
    const addEvent = async () => {
      demo.addStatus = false
      let data = {
        mnumber: demo.addData.mnumber,
        ordertime: demo.addData.ordertime,
        orderid: demo.addData.orderid,
        tasklevel: demo.addData.tasklevel,
        opensettings: demo.addData.opensettings,
        shipmentprogress: demo.addData.shipmentprogress,
        mstatus:demo.addData.mstatus,
        remarks: demo.addData.remarks,
        salesman: demo.addData.salesman
      }
      data.mstatus="执行中"
      console.log(data)
      const res = await request.put('/productiontask/productiontasks/addProductiontasks', data)
      console.log(demo.addData)
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }
    const saveEvent1 = async() => {
      demo.addStatus = false;
      let data={
        mnumber: demo.addData.mnumber,
        ordertime: demo.addData.ordertime,
        orderid: demo.addData.orderid,
        tasklevel: demo.addData.tasklevel,
        opensettings: demo.addData.opensettings,
        shipmentprogress: demo.addData.shipmentprogress,
        mstatus:demo.addData.mstatus,
        remarks: demo.addData.remarks,
        salesman: demo.addData.salesman
      }
      data.mstatus="制单"
      console.log(data)
      const res=await request.put('/productiontask/productiontasks/addProductiontasks',data)
      console.log(demo.addData)
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }
    const deleteEvent = async (row) => {
      alert("已删除" + row.missonid + "销售合同")
      const res = await request.delete('/productiontask/productiontasks/deleteProductiontasks/' + row.missonid)
      if (res.data.code == 0) {
        return res.data.message
      }
      reload()
      // await findProductiontasks()
      return Promise.reject((new Error(res.data.message)))
    }

    return {
      demo,
      orders1,
      // findOrders,
      selectAllOrders,
      addOrderNumber,
      findProductiontasks,
      findProductionTasksByMnumber,
      addProductiontasks,
      addEvent,
      updateEvent,
      submitEvent,
      deleteEvent,
      saveEvent,
      saveEvent1,
    }
  }
}
</script>

<style scoped>

</style>
