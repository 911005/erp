<template>
  <div>
    <vxe-input v-model="demo.searchInput1" placeholder="输入合同编号" type="search" ></vxe-input>
    <vxe-button status="primary" content="查询" @click="findSalescontractsByNumber()"></vxe-button>
    <vxe-button status="primary" content="查询所有合同信息" @click="findSalescontracts()"></vxe-button>
    <vxe-button status="primary" content="新增合同信息" @click="addSalesContract()"></vxe-button>
    <vxe-table
      height="495"
      :data="demo.salesContracts">
      <vxe-column type="seq" width="60" field="salescontractid" title="编号"></vxe-column>
      <vxe-column field="number" title="合同编号"></vxe-column>
      <vxe-column field="contractamount" title="合同金额"></vxe-column>
      <vxe-column field="contratype" title="合同类别"></vxe-column>
      <vxe-column field="signingtime" title="签订时间"></vxe-column>
      <vxe-column field="customername" title="客户名称"></vxe-column>
      <vxe-column field="projectname" title="工程名称"></vxe-column>
      <vxe-column field="projectaddress" title="交货地址"></vxe-column>
      <vxe-column field="transportationdistance" title="运距"></vxe-column>
      <vxe-column field="supplyperiodstart" title="开始供货时间"></vxe-column>
      <vxe-column field="creator" title="业务员"></vxe-column>
      <vxe-column title="操作" width="180">
        <template #default="{ row }">
          <vxe-button status="warning" content="编辑" @click="updateEvent(row)"></vxe-button>
          <vxe-button status="danger" content="删除" @click="deleteEvent(row)"></vxe-button>
        </template>
      </vxe-column>
    </vxe-table>

    <!--    弹窗-->
    <vxe-modal v-model="demo.value5" width="800" show-footer>
      <vxe-table
        stripe
        height="495"
        :span-method="colspanMethod"
        :data="projects">
        <vxe-column type="seq" width="60"></vxe-column>
        <vxe-column field="projectname" title="工程名称"></vxe-column>
        <vxe-column field="projecttype" title="工程类别"></vxe-column>
        <vxe-column field="projectlevel" title="工程级别"></vxe-column>
        <vxe-column field="poursquare" title="浇筑方量"></vxe-column>
        <vxe-column field="projectaddress" title="工程地址"></vxe-column>
        <vxe-column field="transportationdistance" title="运输距离"></vxe-column>
        <vxe-column field="startdate" title="预计开工"></vxe-column>
        <vxe-column field="operate" title="Operate" #default="{ row }">
          <vxe-button type="text" status="danger" content="添加" @click="addProjectname(row)"></vxe-button>
        </vxe-column>
      </vxe-table>
    </vxe-modal>



    <!--  编辑弹窗-->
    <vxe-modal v-model="demo.status" :title=" '编辑&保存'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
      <vxe-form :data="demo.updateData" title-align="right" title-width="100" >
        <vxe-form-item title="销售合同" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>

        <vxe-form-item field="number" title="合同编号" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.number" placeholder="合同编号" disabled></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="contratype" title="合同类别" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.contratype" placeholder="请选择合同类型">
              <vxe-option :value="'长期合同'" label="长期合同"></vxe-option>
              <vxe-option :value="'短期合同'" label="短期合同"></vxe-option>
            </vxe-select>
          </template>
        </vxe-form-item>

        <vxe-form-item field="contractamount" title="合同金额" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.contractamount" placeholder="合同金额"></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="projectname" title="工程名称" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="demo.updateData.projectid" :model-value="demo.updateData.projectname" placeholder="请选择工程名称" @click="selectAllProjects"></vxe-select>
<!--            <vxe-select v-model="data.projectid" :options="demo.projects" placeholder="请选择工程名称"></vxe-select>-->
          </template>
        </vxe-form-item>

        <vxe-form-item field="customername" title="客户名称" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.customername" placeholder="客户名称"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="constructionunit" title="施工单位" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.constructionunit" placeholder="施工单位"></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="construction" title="建设单位" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.construction" placeholder="建设单位"></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="projectaddress" title="施工地址" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.projectaddress" placeholder="施工地址"></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="poursquare" title="浇筑方量" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.poursquare" placeholder="浇筑方量" type="integer"></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="transportationdistance" title="运输距离" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.transportationdistance" placeholder="运输距离" type="integer"></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="signingtime" title="签订日期" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.signingtime" placeholder="签订日期" type="datetime"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="supplyperiodstart" title="供货期开始" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.supplyperiodstart" placeholder="供货期开始" type="datetime"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="supplyperiodend" title="供货期结束" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.supplyperiodend" placeholder="供货期结束" type="datetime"></vxe-input>
          </template>
        </vxe-form-item>


        <vxe-form-item field="creator" title="制单人" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.creator" placeholder="制单人"></vxe-input>
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
    <vxe-modal v-model.sync="demo.addStatus" :title=" '新增&保存'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
      <vxe-form :data="demo.addData" title-align="right" title-width="100" >
        <vxe-form-item title="销售合同" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>

        <vxe-form-item field="number" title="合同编号" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.number" placeholder="合同编号" disabled></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="contratype" title="合同类别" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.contratype" placeholder="请选择合同类型">
              <vxe-option :value="'长期合同'" label="长期合同"></vxe-option>
              <vxe-option :value="'短期合同'" label="短期合同"></vxe-option>
            </vxe-select>
          </template>
        </vxe-form-item>

        <vxe-form-item field="contractamount" title="合同金额" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.contractamount" placeholder="合同金额"></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="projectid" title="工程名称" :span="12" :item-render="{}">
          <template #default="{ data }">
<!--            <vxe-select v-model="projectname" :model-value="demo.updateData.projectname" placeholder="请选择工程名称" @click="selectAllProjects"></vxe-select>-->
            <vxe-select v-model="demo.addData.projectid" :model-value="demo.addData.projectname" placeholder="请选择工程名称" @click="selectAllProjects"></vxe-select>
<!--            <vxe-select v-model="data.projectid" :options="demo.projects" placeholder="请选择工程名称"></vxe-select>-->
          </template>
        </vxe-form-item>

        <vxe-form-item field="customername" title="客户名称" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="customername" placeholder="客户名称" ></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="constructionunit" title="施工单位" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.constructionunit" placeholder="施工单位" ></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="construction" title="建设单位" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.construction" placeholder="建设单位" ></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="projectaddress" title="施工地址" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.projectaddress" placeholder="施工地址" ></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="poursquare" title="浇筑方量" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.poursquare" placeholder="浇筑方量" type="integer" ></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="transportationdistance" title="运输距离" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.transportationdistance" placeholder="运输距离" type="integer" ></vxe-input>
          </template>
        </vxe-form-item>


        <vxe-form-item field="signingtime" title="签订日期" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.signingtime" placeholder="签订日期" type="datetime"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="supplyperiodstart" title="供货期开始" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.supplyperiodstart" placeholder="供货期开始" type="datetime"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="supplyperiodend" title="供货期结束" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.supplyperiodend" placeholder="供货期结束" type="datetime"></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item field="creator" title="制单人" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.creator" placeholder="制单人"></vxe-input>
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
import {reactive,onMounted,ref} from "vue";
import request from "@/utils/request";

export default {

  name: "index",
  setup(){
    onMounted(() => {
      findSalescontracts()
      findProjects()
      generateNumber()
    })
    const savedCounter = localStorage.getItem("counter"); // 从本地存储中获取上次使用的计数器值
    const demo = reactive({
      value5: false,
      counter: savedCounter ? Number(savedCounter) : 0, // 如果存在保存的计数器值，则使用它；否则初始化为 0
      number:'',
      projectid:'',
      projectname:'',
      salesContracts:[],
      status: false,
      addStatus: false,
      // updateData: [],
      addData: {
        number:'',
        contratype:'',
        contractamount:'',
        // signingtime:'',
        projectid:'',
        projectname:'',
        supplyperiodstart:'',
        supplyperiodend:'',
        creator:''
      },
      // projects: [],
      updateData: {
        number:'',
        contratype:'',
        contractamount:'',
        // signingtime:'',
        projectid:'',
        projectname:'',
        supplyperiodstart:'',
        supplyperiodend:'',
        creator:''
      }
    })

    const projects = ref([]);

    const selectAllProjects=async () =>{
      demo.value5 = true
    }

    //增加
    const addProjectname=async (row)=>{
      // alert(row.projectname);
      demo.addData.projectid=row.projectid;
      demo.addData.projectname=row.projectname;
      demo.addData.customername=row.customername;
      demo.addData.constructionunit=row.constructionunit;
      demo.addData.construction=row.construction;
      demo.addData.projectaddress=row.projectaddress;
      demo.addData.poursquare=row.poursquare;
      demo.addData.transportationdistance=row.transportationdistance;

      demo.updateData.projectid=row.projectid;
      demo.updateData.projectname=row.projectname;
      demo.updateData.customername=row.customername;
      demo.updateData.constructionunit=row.constructionunit;
      demo.updateData.construction=row.construction;
      demo.updateData.projectaddress=row.projectaddress;
      demo.updateData.poursquare=row.poursquare;
      demo.updateData.transportationdistance=row.transportationdistance;

      demo.value5=false;
    }

    const findSalescontracts = async () =>{
      console.log(111)
      const res = await request.get('/salesContract/salescontract/findAllSalescontracts');
      console.log(res)
      demo.salesContracts = res.data
      console.log(demo.salesContracts)
      return res
    }
    const findSalescontractsByNumber = async () =>{
      const res = await request.get('/salesContract/salescontract/findSalescontractsByNumber/' +demo.searchInput1);
      console.log(res)
      demo.salesContracts = res.data
      console.log(demo.salesContracts)
      return res
    }
    const findProjects = async () => {
      console.log(111)
      const res = await request.get('/project/findAllProject');
      console.log(res)
      projects.value = res.data
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
      const res = await request.put('/salesContract/salescontract/updateSalescontract', data);
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));

    }
    const generateNumber=async () => {
      const first="HT";
      const now = new Date();
      const year = now.getFullYear().toString().substr(2);
      const month = `0${now.getMonth() + 1}`.slice(-2);
      const day = `0${now.getDate()}`.slice(-2);
      const counterStr = `00${++demo.counter}`.slice(-3); // 计数器自增，并将其转换为带前导零的三位数
      const number = `${first}${year}${month}${day}${counterStr}`; // 将前缀、当前日期和计数器拼接成字符串，并赋值给 generatedString 变量
      demo.number=number;
      localStorage.setItem("counter",demo.counter);
      return number
    }
      const addSalesContract = async () => {
        demo.addStatus = true
        await generateNumber()
        demo.addData.number=demo.number
      }

      const addEvent = async () => {
        demo.addStatus = false
        let data = {
          number: demo.addData.number,
          contratype: demo.addData.contratype,
          contractamount: demo.addData.contractamount,
          signingtime: demo.addData.signingtime,
          projectid: demo.addData.projectid,
          supplyperiodstart: demo.addData.supplyperiodstart,
          supplyperiodend: demo.addData.supplyperiodend,
          creator: demo.addData.creator
        }
        console.log(data)
        const res = await request.post('/salesContract/salescontract/addSalescontract', data)
        console.log(demo.addData)
        if (res.data.code === 0) {
          return res.data.message;
        }
        return Promise.reject(new Error(res.data.message));
      }
      const deleteEvent = async (row) => {
        alert("已删除" + row.salescontractid + "销售合同")
        const res = await request.delete('/salesContract/salescontract/deleteSalescontract/' + row.salescontractid)
        if (res.data.code == 0) {
          return res.data.message
        }
        reload()
        await findSalescontracts()
        return Promise.reject((new Error(res.data.message)))
      }

      return {
        demo,
        projects,
        addProjectname,
        addEvent,
        addSalesContract,
        findSalescontracts,
        findSalescontractsByNumber,
        updateEvent,
        submitEvent,
        deleteEvent,
        generateNumber,
        selectAllProjects
      }
    }
}
</script>

<style scoped>

</style>
