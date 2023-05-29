<template>
<div>
    <vxe-button status="primary" content="查询" @click="findCustomers()"></vxe-button>
    <vxe-button status="primary" content="新增" @click="addCustomer()"></vxe-button>
    <vxe-table
      :data="cus.customers">
      <vxe-column type="seq" width="60" field="id"></vxe-column>
      <vxe-column field="unitname" title="单位名称"></vxe-column>
      <vxe-column field="unittype" title="单位类型"></vxe-column>
      <vxe-column field="unitphone" title="联系电话"></vxe-column>
      <vxe-column field="unitaddress" title="联系地址"></vxe-column>
      <vxe-column field="salesman" title="业务员"></vxe-column>
      <vxe-column field="state" title="状态"></vxe-column>
      <vxe-column field="remarks" title="备注"></vxe-column>
      <vxe-column title="操作" width="240">
        <template #default="{ row }">
          <vxe-button status="warning" content="编辑" @click="updateEvent(row)"></vxe-button>
          <vxe-button status="danger" content="删除" @click="deleteEvent(row)"></vxe-button>
        </template>
      </vxe-column>
    </vxe-table>

    <!--  编辑弹窗-->
    <vxe-modal v-model="cus.status" :title=" '新增&保存'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
      <vxe-form :data="cus.updateData" title-align="right" title-width="100" >
        <vxe-form-item title="Basic information" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
        <vxe-form-item field="unitname" title="单位名称" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.unitname" placeholder="请输入单位名称"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="unittype" title="单位类型" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.unittype" placeholder="请输入单位类型"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="legalrepresentative" title="法人代表" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.legalrepresentative" placeholder="请输入法人代表"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="unitphone" title="联系电话" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.unitphone" placeholder="请输入联系电话"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="faxnumber" title="传真号" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.faxnumber" placeholder="请输入传真号"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="unitemail" title="电子邮箱" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.unitemail" placeholder="请输入电子邮箱"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="unitaddress" title="联系地址" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.unitaddress" placeholder="请输入联系地址"></vxe-input>
        </template>
        </vxe-form-item>
        <vxe-form-item field="zipcode" title="邮编" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.zipcode" placeholder="请输入邮编"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="salesman" title="业务员" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.salesman" placeholder="请输入业务员"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="ratepayingnumber" title="纳税号" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.ratepayingnumber" placeholder="请输入纳税号"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="state" title="状态" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.state" placeholder="请输入状态"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="remarks" title="备注" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.remarks" placeholder="请输入备注"></vxe-input>
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
    <vxe-modal v-model="cus.addStatus" :title=" '新增&保存'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
      <vxe-form :data="cus.addData" title-align="right" title-width="100" >
        <vxe-form-item title="Basic information" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>

        <vxe-form-item field="unitname" title="单位名称" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.unitname" placeholder="请输入单位名称"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="unittype" title="单位类型" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.unittype" placeholder="请输入单位类型"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="unitphone" title="联系电话" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.unitphone" placeholder="请输入联系电话"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="unitaddress" title="联系地址" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.unitaddress" placeholder="请输入联系地址"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="salesman" title="业务员" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.salesman" placeholder="请输入业务员"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="state" title="状态" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.state" placeholder="请输入状态"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="remarks" title="备注" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.remarks" placeholder="请输入备注"></vxe-input>
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
      findCustomers()
    })
    const cus=reactive({
      customers:[],
      status:false,
      addStatus:false,
      updateData:[],
      addData:[]
    })
    const findCustomers=async () => {
      console.log(111)
      const res = await request.get('/customer/customer/findAllCustomers');
      console.log(res)
      cus.customers=res.data
      alert()
      console.log(cus.customers)
      return res
    }

    const deleteEvent=async (row) => {
      alert(row.id)
      const res = await request.delete('/customer/customer/deleteCustomer/'+row.id)
      if (res.data.code==0){
        return res.data.message
      }
      reload()
      return Promise.reject((new Error(res.data.message)))
    }
    const updateEvent=(row)=>{
      cus.status=true
      cus.updateData=row
    }

    const submitEvent=async () => {
      console.log(cus.updateData)
      cus.status=false
      let data=cus.updateData
      const res = await request.put('/customer/customer/updateCustomer',data);
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }

    const addCustomer=async () => {
      cus.addStatus=true
    }

    const addEvent=async () => {
      cus.addStatus=false
      let data={
        unitname:cus.addStatus.unitname,
        unittype:cus.addStatus.unittype,
        legalrepresentative:cus.addStatus.legalrepresentative,
        unitphone:cus.addStatus.unitphone,
        faxnumber:cus.addStatus.faxnumber,
        unitemail:cus.addStatus.unitemail,
        unitaddress:cus.addStatus.unitaddress,
        zipcode:cus.addStatus.zipcode,
        salesman:cus.addStatus.salesman,
        ratepayingnumber:cus.addStatus.ratepayingnumber,
        status:cus.addStatus.status,
        remarks:cus.addStatus.remarks
      }
      console.log(data)
      const res=await request.put('/customer/customer/addCustomer',data)
      console.log(cus.addData)
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }

    return {
      cus,
      findCustomers,
      deleteEvent,
      updateEvent,
      submitEvent,
      addCustomer,
      addEvent,
    }
  },

}

</script>

<style scoped>

</style>

