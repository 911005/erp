<template>
<div>
  <vxe-input v-model="sto.searchInput1" placeholder="请输入储料仓名称" type="search" ></vxe-input>
  <vxe-button status="primary" content="查询" @click="findStoragesilosBystoragesiloName()"></vxe-button>
  <vxe-input v-model="sto.searchInput2" placeholder="请输入储存类别" type="search" ></vxe-input>
  <vxe-button status="primary" content="查询" @click="findStoragesilosBystorageslioType()"></vxe-button>
  <vxe-button status="primary" content="查询" @click="findStoragesilos()"></vxe-button>
  <vxe-button status="primary" content="新增" @click="addStoragesilo()"></vxe-button>
  <vxe-table
    :data="sto.storagesilos">
    <vxe-column type="seq" width="60" field="id"></vxe-column>
    <vxe-column field="storagesiloname" title="储料仓名称"></vxe-column>
    <vxe-column field="storagesliotype" title="储存类别"></vxe-column>
    <vxe-column field="volume" title="容量"></vxe-column>
    <vxe-column field="warnuplimit" title="预警上限"></vxe-column>
    <vxe-column field="warndpwnlimit" title="预警下限"></vxe-column>
    <vxe-column field="safevolume" title="安全容量"></vxe-column>
    <vxe-column field="username" title="库管员"></vxe-column>
    <vxe-column field="remarks" title="备注"></vxe-column>
    <vxe-column field="storagesilostate" title="状态"></vxe-column>
    <vxe-column title="操作" width="240">
      <template #default="{ row }">
        <vxe-button status="warning" content="编辑" @click="updateEvent(row)"></vxe-button>
        <vxe-button status="danger" content="删除" @click="deleteEvent(row)"></vxe-button>
      </template>
    </vxe-column>
  </vxe-table>



  <!--  编辑弹窗-->
  <vxe-modal v-model="sto.status" :title=" '新增&保存'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
    <vxe-form :data="sto.updateData" title-align="right" title-width="100" >
      <vxe-form-item title="Basic information" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
      <vxe-form-item field="storagesiloname" title="储料仓名称" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.storagesiloname" placeholder="请输入储料仓名称"></vxe-input>
        </template>
      </vxe-form-item>
      <vxe-form-item field="storagesliotype" title="储存类别" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.storagesliotype" placeholder="请输入储存类别"></vxe-input>
        </template>
      </vxe-form-item>
      <vxe-form-item field="volume" title="容量" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.volume" placeholder="请输入容量"></vxe-input>
        </template>
      </vxe-form-item>
      <vxe-form-item field="warnuplimit" title="预警上限" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.warnuplimit" placeholder="请输入预警上限"></vxe-input>
        </template>
      </vxe-form-item>
      <vxe-form-item field="warndpwnlimit" title="预警下限" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.warndpwnlimit" placeholder="请输入预警下限"></vxe-input>
        </template>
      </vxe-form-item>
      <vxe-form-item field="safevolume" title="安全容量" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.safevolume" placeholder="请输入安全容量"></vxe-input>
        </template>
      </vxe-form-item>
      <vxe-form-item field="username" title="库管员" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.username" placeholder="请输入库管员"></vxe-input>
        </template>
      </vxe-form-item>
      <vxe-form-item field="remarks" title="备注" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.remarks" placeholder="请输入备注"></vxe-input>
        </template>
      </vxe-form-item>
      <vxe-form-item field="storagesilostate" title="状态" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.storagesilostate" placeholder="请输入状态"></vxe-input>
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
  <vxe-modal v-model="sto.addStatus" :title=" '新增&保存'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
    <vxe-form :data="sto.addData" title-align="right" title-width="100" >
      <vxe-form-item title="Basic information" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>

      <vxe-form-item field="storagesiloname" title="储料仓名称" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.storagesiloname" placeholder="请输入储料仓名称"></vxe-input>
        </template>
      </vxe-form-item>
      <vxe-form-item field="storagesliotype" title="储存类别" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.storagesliotype" placeholder="请输入储存类别"></vxe-input>
        </template>
      </vxe-form-item>
      <vxe-form-item field="volume" title="容量" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.volume" placeholder="请输入容量"></vxe-input>
        </template>
      </vxe-form-item>
      <vxe-form-item field="warnuplimit" title="预警上限" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.warnuplimit" placeholder="请输入预警上限"></vxe-input>
        </template>
      </vxe-form-item>
      <vxe-form-item field="warndpwnlimit" title="预警下限" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.warndpwnlimit" placeholder="请输入预警下限"></vxe-input>
        </template>
      </vxe-form-item>
      <vxe-form-item field="safevolume" title="安全容量" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.safevolume" placeholder="请输入安全容量"></vxe-input>
        </template>
      </vxe-form-item>
      <vxe-form-item field="username" title="库管员" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.username" placeholder="请输入库管员"></vxe-input>
        </template>
      </vxe-form-item>
      <vxe-form-item field="remarks" title="备注" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.remarks" placeholder="请输入备注"></vxe-input>
        </template>
      </vxe-form-item>
      <vxe-form-item field="storagesilostate" title="状态" :span="12" :item-render="{}">
        <template #default="{ data }">
          <vxe-input v-model="data.storagesilostate" placeholder="请输入状态"></vxe-input>
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
import {reactive, onMounted} from "vue";
import request from "@/utils/request";
export default {
  name: "index",
  setup() {
    onMounted(() => {
      findStoragesilos()
    })
    const sto = reactive({
      searchInput1:[],
      searchInput2:[],
      storagesilos: [],
      status: false,
      addStatus: false,
      updateData: [],
      addData: []
    })
    const findStoragesilos = async () => {
      console.log(111)
      const res = await request.get('/storagesilo/storagesilo/findAllStoragesilos');
      console.log(res)
      sto.storagesilos = res.data
      console.log(sto.storagesilos)
      return res
    }
    const findStoragesilosBystoragesiloName = async () =>{
      const res = await request.get('/storagesilo/storagesilo/findStoragesilosBystoragesiloName/' +sto.searchInput1);
      console.log(res)
      sto.storagesilos = res.data
      console.log(sto.storagesilos)
      return res
    }
    const findStoragesilosBystorageslioType = async () =>{
      const res = await request.get('/storagesilo/storagesilo/findStoragesilosBystorageslioType/' +sto.searchInput2);
      console.log(res)
      sto.storagesilos = res.data
      console.log(sto.storagesilos)
      return res
    }
    const updateEvent=(row)=>{
      sto.status=true
      sto.updateData=row
    }
    const submitEvent=async () => {
      console.log(sto.updateData)
      sto.status=false
      let data=sto.updateData
      const res = await request.put('/storagesilo/storagesilo/updateStoragesilo',data);
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }
    const deleteEvent=async (row) => {
      alert(row.id)
      const res = await request.delete('/storagesilo/storagesilo/deleteStoragesilo/'+row.id)
      if (res.data.code==0){
        return res.data.message
      }
      reload()
      return Promise.reject((new Error(res.data.message)))
    }
    const addStoragesilo=async () => {
      sto.addStatus=true
    }

    const addEvent=async () => {
      sto.addStatus=false
      let data={
        storagesiloname:sto.addData.storagesiloname,
        storagesliotype:sto.addData.storagesliotype,
        volume:sto.addData.volume,
        warnuplimit:sto.addData.warnuplimit,
        warndpwnlimit:sto.addData.warndpwnlimit,
        safevolume:sto.addData.safevolume,
        username:sto.addData.username,
        remarks:sto.addData.remarks,
        storagesilostate:sto.addData.storagesilostate
      }
      console.log(data)
      const res=await request.put('/storagesilo/storagesilo/addStoragesilo',data)
      console.log(sto.addData)
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }
    return {
      sto,
      findStoragesilos,
      updateEvent,
      submitEvent,
      deleteEvent,
      addStoragesilo,
      findStoragesilosBystoragesiloName,
      findStoragesilosBystorageslioType,
      addEvent,
    }
  },
}
</script>

<style scoped>

</style>
