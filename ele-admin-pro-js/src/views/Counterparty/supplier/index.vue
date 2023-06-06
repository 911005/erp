<template>
  <div>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <vxe-input v-model="demo.searchInput1" placeholder="请输入单位名称" type="search" ></vxe-input>
    <vxe-button status="primary" content="查询" @click="findByName()"></vxe-button>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <vxe-input v-model="demo.searchInput2" placeholder="请输入采购员" type="search" ></vxe-input>
    <vxe-button status="primary" content="查询" @click="findBySaleman()"></vxe-button>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <vxe-button status="primary" content="刷新" @click="findSuppliers()"></vxe-button>
    <vxe-button status="primary" content="新增" @click="addSupplier()"></vxe-button>
    <vxe-table
      height="595"
      :data="demo.Suppliers">
      <vxe-column type="seq" width="60" field="id" title="编号"></vxe-column>
      <vxe-column field="suppliername" title="供应商名称"></vxe-column>
      <vxe-column field="suppliertype" title="供应商类别"></vxe-column>
      <vxe-column field="phone" title="联系电话"></vxe-column>
      <vxe-column field="supplieraddress" title="联系地址"></vxe-column>
      <vxe-column  field="saleman" title="采购员"></vxe-column>
      <vxe-column field="status" title="状态" :cell-class-name="getBackgroundColor"></vxe-column>
      <vxe-column title="操作" width="180">
        <template #default="{ row }">
          <vxe-button  status="warning" content="编辑" @click="updateEvent(row)"></vxe-button>
          <vxe-button status="danger" icon="vxe-icon-delete" @click="deleteEvent(row)"></vxe-button>
        </template>
      </vxe-column>
    </vxe-table>

    <vxe-modal v-model="demo.value5" width="1000" show-footer>
      <vxe-table
        stripe
        :span-method="colspanMethod"
        :data="demo.SupplyMaterials">
        <vxe-column type="seq" width="60" field="materialid" title="编号"></vxe-column>
        <vxe-column field="platformmaterialname" title="平台原材料"></vxe-column>
        <vxe-column field="supplymaterialname" title="供应原材料"></vxe-column>
        <vxe-column field="specifications" title="规格类型"></vxe-column>
        <vxe-column field="operate" title="operate" #default="{ row }">
          <vxe-button type="text" status="danger" content="添加" @click="addSupplyMaterials(row)"></vxe-button>
        </vxe-column>
      </vxe-table>
    </vxe-modal>


    <!--  编辑弹窗-->
    <vxe-modal v-model="demo.status" :title=" '新增'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
      <vxe-form :data="demo.updateData" title-align="right" title-width="100" >
        <vxe-form-item title="原材料供应商" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
        <vxe-form-item field="suppliername" title="单位名称" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.suppliername" placeholder="单位名称"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="suppliertype" title="单位类型" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.suppliertype" placeholder="单位类型" disabled></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="legalrepresentative" title="法人代表" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.legalrepresentative" placeholder="法人代表"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="supplieraddress" title="联系地址" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.supplieraddress" placeholder="联系地址"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="phone" title="联系电话" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.phone" placeholder="联系电话"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="email" title="电子邮箱" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.email" placeholder="电子邮箱"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="faxnumber" title="传真号" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.faxnumber" placeholder="传真号"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="zipcode" title="邮编" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.zipcode" placeholder="邮编"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="saleman" title="采购员" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.saleman" :options="demo.options" placeholder="采购员"></vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="taxidnumber" title="纳税号" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.taxidnumber" placeholder="纳税号"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item title="供应原材料" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
        <vxe-form-item field="materialid" title="供应原材料" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="demo.updateData.materialid" :model-value="demo.updateData.supplymaterialname" placeholder="供应原材料" @click="selectAllSups"></vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="platformmaterialname" title="平台原材料" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="demo.updateData.platformmaterialname" placeholder="平台原材料"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="specifications" title="规格类型" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="demo.updateData.specifications" placeholder="规格类型"></vxe-input>
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
        <vxe-form-item title="原材料供应商" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
        <vxe-form-item field="suppliername" title="单位名称" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.suppliername" placeholder="单位名称"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="suppliertype" title="单位类型" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="demo.addData.suppliertype" placeholder="单位类型" disabled></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="legalrepresentative" title="法人代表" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.legalrepresentative" placeholder="法人代表"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="supplieraddress" title="联系地址" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.supplieraddress" placeholder="联系地址"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="phone" title="联系电话" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.phone" placeholder="联系电话"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="email" title="电子邮箱" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.email" placeholder="电子邮箱"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="faxnumber" title="传真号" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.faxnumber" placeholder="传真号"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="zipcode" title="邮编" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.zipcode" placeholder="邮编"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="saleman" title="采购员" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.saleman" :options="demo.options" placeholder="采购员"></vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="taxidnumber" title="纳税号" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.taxidnumber" placeholder="纳税号"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item title="供应原材料" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
        <vxe-form-item field="supplymaterialname" title="供应原材料" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="demo.addData.materialid" :model-value="demo.addData.supplymaterialname" placeholder="供应原材料" @click="selectAllSups"></vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="platformmaterialname" title="平台原材料" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="demo.addData.platformmaterialname" placeholder="平台原材料" ></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="specifications" title="规格类型" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="demo.addData.specifications" placeholder="规格类型"></vxe-input>
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
<style>
.bg-red {
  background-color: #FFCCCC;
}

.bg-green {
  background-color: #CCFFCC;
}
</style>
<script>
import {onMounted, reactive} from "vue";
import request from "@/utils/request";

export default {
  name: "index",
  setup() {
    onMounted(() => {
      findSuppliers()
      findSupplyM()
      findToSuppliers()
      getBackgroundColor()
    })
    const demo = reactive({
      value5:false,
      options:[],
      searchInput1: [],
      searchInput2: [],
      Suppliers: [],
      SupplyMaterials:[],
      status: false,
      addStatus: false,
      updateData:{
        materialid:'',
        platformmaterialname:'',
        supplymaterialname:'',
        specifications:'',
      },
      addData:{
        suppliertype:'原材料供应商',
        materialid:'',
        platformmaterialname:'',
        supplymaterialname:'',
        specifications:'',
      }
    })
    const getBackgroundColor = async (row) =>{
      const status = row.status
      if(status==="启用"){
        return"bg-green";
      }
      else if(status==="停用"){
        return "bg-red"
      }
    }
    const findByName = async () =>{
      const res = await request.get('/supplier/supplier/findByName/' +demo.searchInput1);
      console.log(res)
      demo.Suppliers = res.data
      console.log(demo.Suppliers)
      return res
    }
    const findBySaleman = async () =>{
      const res = await request.get('/supplier/supplier/findBySaleman/' +demo.searchInput2);
      console.log(res)
      demo.Suppliers = res.data
      console.log(demo.Suppliers)
      return res
    }
    const findSupplyM = async () => {
      console.log(111)
      const res = await request.get('/test1/SupplyMaterials/findAllSupplyM');
      console.log(res)
      demo.SupplyMaterials = res.data
      console.log(demo.SupplyMaterials)
      return res
    }
    const findSuppliers = async () => {
      console.log(111)
      const res = await request.get('/supplier/supplier/findAllSuppliers');
      console.log(res)
      demo.Suppliers = res.data
      console.log(demo.Suppliers)
      return res
    }
    const findToSuppliers = async () =>{
      const res = await request.get('/system/user/findAllUsers');
      const data=res.data
      if (data && data.length > 0) {
        demo.options = data.map(item => {
          return { value: item.username, label: item.username};
        });
      }
      return res
    }
    const selectAllSups=async ()=>{
      demo.value5=true
    }
    const addSupplyMaterials=async (row) =>{
      if (demo.addStatus=true){
        demo.addData.materialid=row.materialid;
        demo.addData.platformmaterialname=row.platformmaterialname;
        demo.addData.supplymaterialname=row.supplymaterialname;
        demo.addData.specifications=row.specifications;
      }
      else if (demo.status=true){
        demo.updateData.materialid=row.materialid;
        demo.updateData.platformmaterialname=row.platformmaterialname;
        demo.updateData.supplymaterialname=row.supplymaterialname;
        demo.updateData.specifications=row.specifications;
      }
      demo.value5=false
    }
    const deleteEvent = async (row) => {
      alert(row.id)
      const res = await request.delete('/supplier/supplier/deleteSupplier/' + row.id)
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
      const res = await request.put('/supplier/supplier/updateSupplier', data);
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }

    const addSupplier = async () => {
      demo.addStatus = true
    }

    const addEvent = async () => {
      demo.addStatus = false
      let data = {
        suppliername: demo.addData.suppliername,
        suppliertype: demo.addData.suppliertype,
        phone: demo.addData.phone,
        supplieraddress: demo.addData.supplieraddress,
        saleman: demo.addData.saleman,
        remarks: demo.addData.remarks,
        faxnumber: demo.addData.faxnumber,
        zipcode: demo.addData.zipcode,
        legalrepresentative: demo.addData.legalrepresentative,
        email: demo.addData.email,
        taxidnumber: demo.addData.taxidnumber,
        materialid: demo.addData.materialid,
        status: demo.addData.status,
        platformmaterialname: demo.addData.platformmaterialname,
        supplymaterialname: demo.addData.supplymaterialname,
        specifications: demo.addData.specifications
      }
      console.log(data)
      data.status='启用'
      const res = await request.post('/supplier/supplier/addSupplier', data)
      console.log(demo.addData)
      if (res.data.code === 0) {
        return res.data.message;
      }
      location.reload()
      return Promise.reject(new Error(res.data.message));
    }
    return{
      demo,
      findSuppliers,
      findSupplyM,
      findByName,
      findBySaleman,
      getBackgroundColor,
      findToSuppliers,
      selectAllSups,
      addSupplyMaterials,
      deleteEvent,
      updateEvent,
      submitEvent,
      addSupplier,
      addEvent,
    }

  },
}
</script>

<style scoped>

</style>

