<template xmlns:vxe-table="http://www.w3.org/1999/html">
  <div>
<!--    <vxe-input v-model="demo.searchInput1" placeholder="请输入合同编号" type="search" ></vxe-input>-->
<!--    <vxe-button status="primary" content="查询" @click="findPumpTrucksBypumpTruckid()"></vxe-button>-->
<!--    <vxe-input v-model="demo.searchInput2" placeholder="请输入客户名称" type="search" ></vxe-input>-->
<!--    <vxe-button status="primary" content="查询" @click="findPumpTrucksBypumpTruckNumber()"></vxe-button>-->
<!--    <vxe-button status="primary" content="查询所有合同信息" @click="findPumpTrucks()"></vxe-button>-->
<!--    <vxe-button status="primary" content="新增合同信息" @click="addPumpTruck()"></vxe-button>-->
    <vxe-button status="primary" content="查询所有合同信息" @click="findSalescontracts()"></vxe-button>
    <vxe-table
      :data="demo.salesContracts">
      <vxe-column type="seq" width="60" field="salescontractid" title="编号"></vxe-column>
      <vxe-column field="number" title="合同编号"></vxe-column>
      <vxe-column field="contractamount" title="合同金额"></vxe-column>
      <vxe-column field="contratype" title="合同类别"></vxe-column>
      <vxe-column field="signingtime" title="签订时间"></vxe-column>
      <vxe-column field="unitname" title="客户名称"></vxe-column>
      <vxe-column field="projectname" title="工程名称"></vxe-column>
      <vxe-column field="projectaddress" title="交货地址"></vxe-column>
      <vxe-column field="transportationdistance" title="运距"></vxe-column>
      <vxe-column field="supplyperiodstart" title="开始供货时间"></vxe-column>
      <vxe-column field="creator" title="业务员"></vxe-column>
      <vxe-column title="操作" width="180">
        <template #default="{ row }">
          <vxe-button status="warning" content="编辑" @click="updateEvent(row)"></vxe-button>
        </template>
      </vxe-column>
    </vxe-table>

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

        <vxe-form-item field="unitname" title="客户名称" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.unitname" placeholder="客户名称"></vxe-input>
          </template>
        </vxe-form-item>



<!--        <vxe-pulldown ref="xDown3" destroy-on-close>-->
<!--          <template #default>-->
<!--            <vxe-button icon="vxe-icon-question-circle-fill" @click="clickEvent3">切换下拉表格</vxe-button>-->
<!--          </template>-->
<!--          <template #dropdown>-->
<!--            <div class="my-dropdown3">-->
<!--              <vxe-table-->
<!--                :data="pro.projects">-->
<!--                <vxe-column type="seq" width="60" field="projectid"></vxe-column>-->
<!--                <vxe-column field="projectname" title="工程名称"></vxe-column>-->
<!--                <vxe-column field="customername" title="客户名称"></vxe-column>-->
<!--                <vxe-column field="projectaddress" title="工程地址"></vxe-column>-->
<!--                <vxe-column field="transportationdistance" title="运输（km）"></vxe-column>-->
<!--                <vxe-column field="state" title="状态"></vxe-column>-->
<!--              </vxe-table>-->
<!--            </div>-->
<!--          </template>-->
<!--        </vxe-pulldown>-->


        <vxe-form-item field="projectname" title="工程名称" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.projectname" placeholder="工程名称" suffix-icon="vxe-icon-caret-down" @click="findProject()"></vxe-input>
            <el-dialog title="搜索结果" :visible.sync="dialogVisible" :modal-append-to-body="false">
              <ul>
                <li v-for="(project, index) in projectList" :key="index">{{ project.name }}</li>
              </ul>
            </el-dialog>
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
            <vxe-input v-model="data.signingtime" placeholder="签订日期" type="date"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="supplyperiodstart" title="供货期开始" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.supplyperiodstart" placeholder="供货期开始" type="date"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="supplyperiodend" title="供货期结束" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.supplyperiodend" placeholder="供货期结束" type="date"></vxe-input>
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


<!--    &lt;!&ndash;  新增弹窗&ndash;&gt;-->
<!--    <vxe-modal v-model="demo.addStatus" :title=" '新增&保存'" width="800" min-width="600" min-height="300"  resize destroy-on-close>-->
<!--      <vxe-form :data="demo.addData" title-align="right" title-width="100" >-->
<!--        <vxe-form-item title="Basic information" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>-->

<!--        <vxe-form-item field="pumptruckid" title="车辆编号" :span="12" :item-render="{}">-->
<!--          <template #default="{ data }">-->
<!--            <vxe-input v-model="data.pumptruckid" placeholder="请输入车辆编号"></vxe-input>-->
<!--          </template>-->
<!--        </vxe-form-item>-->

<!--        <vxe-form-item align="center" title-align="left" :span="24">-->
<!--          <template #default>-->
<!--            <vxe-button @click="addEvent">提交</vxe-button>-->
<!--            <vxe-button type="reset">重置</vxe-button>-->
<!--          </template>-->
<!--        </vxe-form-item>-->
<!--      </vxe-form>-->
<!--    </vxe-modal>-->
  </div>
</template>

<script>
import {reactive,onMounted} from "vue";
import request from "@/utils/request";

export default {

  name: "index",
  setup(){
    onMounted(() => {
      findSalescontracts()
    })
    const demo = reactive({
      salesContracts:[],
      projectname: ''
    })
    const dialogVisible = reactive(false)
    const projectList = reactive([])
    const findSalescontracts = async () =>{
      console.log(111)
      const res = await request.get('/salesContract/salescontract/findAllSalescontracts');
      console.log(res)
      demo.salesContracts = res.data
      console.log(demo.salesContracts)
      return res
    }
    const updateEvent=(row)=>{
      demo.status=true
      demo.updateData=row
    }

    const submitEvent=async () => {
      console.log(demo.updateData)
      demo.status=false
      let data=demo.updateData
      const res = await request.put('/salesContract/salescontract/updateSalescontract',data);
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }
    const findProject=async () => {
      projectList.value = [
        { name: '工程1' },
        { name: '工程2' },
        { name: '工程3' }
      ]
      // 显示 Dialog 对话框
      this.dialogVisible = true
    }

    return{
      demo,
      dialogVisible,
      findSalescontracts,
      updateEvent,
      submitEvent,
      findProject,
    }
  }
}
</script>

<style scoped>

</style>
