<template>
  <div>
    <vxe-button status="primary" content="查询" @click="findProjects()"></vxe-button>
    <vxe-button status="primary" content="新增" @click="addProject()"></vxe-button>
    <vxe-table
      :data="pro.projects">
      <vxe-column type="seq" width="60" field="projectid"></vxe-column>
      <vxe-column field="projectname" title="工程名称"></vxe-column>
      <vxe-column field="customername" title="客户名称"></vxe-column>
      <vxe-column field="projectaddress" title="工程地址"></vxe-column>
      <vxe-column field="transportationdistance" title="运输（km）"></vxe-column>
      <vxe-column field="state" title="状态"></vxe-column>
      <vxe-column title="操作" width="240">
        <template #default="{row}">
          <vxe-button status="warning" content="编辑" @click="updateEvent(row)"></vxe-button>
          <vxe-button status="danger" content="删除" @click="deleteEvent(row)"></vxe-button>
        </template>
      </vxe-column>
    </vxe-table>

    <!--  编辑弹窗-->
    <vxe-modal v-model="pro.status" :title=" '新增&保存'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
      <vxe-form :data="pro.updateData" title-align="right" title-width="100" >
        <vxe-form-item title="Basic information" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
        <vxe-form-item field="projectname" title="工程名称" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.projectname" placeholder="请输入工程名称"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="projectprogress" title="工程进度" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.projectprogress" placeholder="请输入工程进度"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="projecttype" title="工程类别" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.projecttype" placeholder="请输入联系电话"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="projectlevel" title="工程级别" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.projectlevel" placeholder="请输入联系地址"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="poursquare" title="浇筑方量" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.poursquare" placeholder="请输入业务员"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="projectaddress" title="工程地址" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.projectaddress" placeholder="请输入状态"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field=" transportationdistance" title="运输距离" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.transportationdistance" placeholder="请输入备注"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="construction" title="建设单位" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.construction" placeholder="请输入备注"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="constructionunit" title="施工" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.constructionunit" placeholder="请输入备注"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="startdate" title="预计开设时间" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.startdate" placeholder="请输入备注"></vxe-input>
          </template>
        </vxe-form-item>
        <!--        //-&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;-->
        <vxe-form-item field="customername" title="客户名称" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.customername" placeholder="请输入备注"></vxe-input>
          </template>
        </vxe-form-item>
        <!--        下拉框-->
        <!--        <vxe-form-item type="select" label="客户名称" title="客户名称2" prop="projectName">-->
        <!--          <vxe-select v-model="pro.projectName">-->
        <!--            <vxe-option v-for="item in pro.projects" :key="item.projectname" :value="item.projectname" :label="item.projectname">-->
        <!--              {{ item.projectname }}-->
        <!--            </vxe-option>-->
        <!--          </vxe-select>-->
        <!--        </vxe-form-item>-->

        <vxe-form-item field="state" title="状态" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.state" placeholder="请输入备注"></vxe-input>
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
    <vxe-modal v-model="pro.addStatus" :title=" '新增&保存'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
      <vxe-form :data="pro.addData" title-align="right" title-width="100" >
        <vxe-form-item title="Basic information" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>

        <vxe-form-item field="projectname" title="工程名称" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.projectname" placeholder="请输入工程名称"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="projectprogress" title="工程进度" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.projectprogress" placeholder="请输入工程进度"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="projecttype" title="工程类别" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.projecttype" placeholder="请输入联系电话"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="projectlevel" title="工程级别" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.projectlevel" placeholder="请输入联系地址"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="poursquare" title="浇筑方量" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.poursquare" placeholder="请输入业务员"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="projectaddress" title="工程地址" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.projectaddress" placeholder="请输入状态"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field=" transportationdistance" title="运输距离" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.transportationdistance" placeholder="请输入备注"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="construction" title="建设单位" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.construction" placeholder="请输入备注"></vxe-input>
          </template>
        </vxe-form-item>
          <vxe-form-item field="constructionunit" title="施工" :span="12" :item-render="{}">
            <template #default="{ data }">
              <vxe-input v-model="data.constructionunit" placeholder="请输入备注"></vxe-input>
            </template>
        </vxe-form-item>
        <vxe-form-item field="startdate" title="预计开设时间" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.startdate" placeholder="请输入备注"></vxe-input>
          </template>
        </vxe-form-item>
<!--        //-&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;-->
        <vxe-form-item field="customername" title="客户名称" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.customername" placeholder="请输入备注"></vxe-input>
          </template>
        </vxe-form-item>
<!--        下拉框-->
<!--        <vxe-form-item type="select" label="客户名称" title="客户名称2" prop="projectName">-->
<!--          <vxe-select v-model="pro.projectName">-->
<!--            <vxe-option v-for="item in pro.projects" :key="item.projectname" :value="item.projectname" :label="item.projectname">-->
<!--              {{ item.projectname }}-->
<!--            </vxe-option>-->
<!--          </vxe-select>-->
<!--        </vxe-form-item>-->

          <vxe-form-item field="state" title="状态" :span="12" :item-render="{}">
            <template #default="{ data }">
              <vxe-input v-model="data.state" placeholder="请输入备注"></vxe-input>
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
import {reactive, onMounted, ref} from "vue";
import request from "@/utils/request";

export default {
  name: "index",
  setup() {
    onMounted(() => {
      findProjects()
    })
    const pro=reactive({
      projectName:'',
      projects:[],
      status:false,
      addStatus:false,
      updateData:[],
      addData:[],
      pId:'1',
    })

    const proData=reactive({
      projectName:'',

      projects2:[{id:1,projectname:'aaa'},{id:2,projectname:'bbb'},{id:2,projectname:'ccc'}]
    })


    const findProjects=async () => {
      console.log(111)
      const res = await request.get('/project/findAllProject');
      console.log(res.data)
      pro.projects=res.data
      // proData.project2=res.data
      return res
    }

    const deleteEvent=async ( row ) => {
      alert(row.projectid)
      const res = await request.delete('/project/deleteProject/'+row.projectid)
      if (res.data.code == 0) {
        return res.data.message
      }
      reload()
      await findProjects()
      return Promise.reject((new Error(res.data.message)))
    }
    const updateEvent=(row)=>{
      pro.status=true
      pro.updateData=row
    }

    const submitEvent=async () => {
      console.log(pro.updateData)
      pro.status=false
      let data=pro.updateData
      const res = await request.put('/project/updateProject',data);
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }

    const addProject=async () => {
      pro.addStatus=true
    }

    const addEvent=async () => {
      pro.addStatus=false
      let data={
        projectname:pro.addData.projectname,
        projectprogress:pro.addData.projectprogress,
        projecttype:pro.addData.projecttype,
        projectlevel:pro.addData.projectlevel,
        poursquare:pro.addData.poursquare,
        projectaddress:pro.addData.projectaddress,
        transportationdistance:pro.addData.transportationdistance,
        construction:pro.addData.construction,
        constructionunit:pro.addData.constructionunit,
        startdate:pro.addData.startdate,
        customername:pro.addData.customername,
        state:pro.addData.state
      }
      console.log(data)
      const res=await request.put('/project/addProject',data)
      console.log(pro.addData)
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }

    return {
      pro,
      findProjects,
      deleteEvent,
      updateEvent,
      submitEvent,
      addProject,
      addEvent,
      proData,

    }
  },

}

</script>

<style scoped>

</style>
