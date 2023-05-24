<template>
  <div>
    <a-layout class="layout">
      <a-layout-content
        :style="{ background: '#fff', padding: '24px', minHeight: '280px' }">
        <!-- 搜索栏 -->
        <div style="float: left"><button @click="findAllPerson">查询</button></div>
        <div style="float: right;margin-right: 8.0%">
          <input v-model="personId"><button @click="findPersonByPersonId(personId)">通过编号查找</button></div>
        <!-- 表格 -->
        <table border="solid">
          <tr>
            <td>序号</td>
            <td>编号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>专业</td>
            <td>手机号</td>
            <td>操作</td>
          </tr>
          <tr v-for="(person , index) in personList.value">
            <td>{{ index+1 }}</td>
            <td>{{ person.personId }}</td>
            <td>{{ person.name }}</td>
            <td>{{ person.sex }}</td>
            <td> {{ person.age }}</td>
            <td>{{ person.major }}</td>
            <td>{{ person.phone }}</td>
            <td><button @click="edit(person)">修改</button><button @click="deletePersonByPersonId(person.personId)">删除</button></td>
          </tr>

          <tr>
            <td></td>
            <td><input disabled v-model="person.personId"></td>
            <td><input v-model="person.name"></td>
            <td><input v-model="person.sex"></td>
            <td><input v-model="person.age"></td>
            <td><input v-model="person.major"></td>
            <td><input v-model="person.phone"></td>
            <td><button style="width: 100%" @click="updatePerson(person)">修改保存</button></td>
          </tr>

          <tr>
            <td></td>
            <td><input v-model="personForSave.personId"></td>
            <td><input v-model="personForSave.name"></td>
            <td><input v-model="personForSave.sex"></td>
            <td><input v-model="personForSave.age"></td>
            <td><input v-model="personForSave.major"></td>
            <td><input v-model="personForSave.phone"></td>
            <td><button style="width: 100%" @click="addPerson(personForSave)">新增保存</button></td>
          </tr>
        </table>
      </a-layout-content>
    </a-layout>
  </div>

</template>

<script>
import {reactive, ref, toRaw} from 'vue';
import {
  findAllPersonList,
  findPersonService,
  deletePersonService,
  addPersonService,
  updatePersonService
} from '@/views/demo/demo2/person';
import {message} from 'ant-design-vue/es';

export default {
  name: 'DemoPractice',
  setup() {
    let personId = ref('')

    let personList = reactive([{
      personId: '',
      name: '',
      sex: '',
      age: '',
      major: '',
      phone: ''
    }]);

    const person = reactive({
      personId: ' ',
      name: ' ',
      sex: ' ',
      age: ' ',
      major: ' ',
      phone: ' '
    });

    let personForSave = reactive({
      personId: '',
      name: '',
      sex: '',
      age: '',
      major: '',
      phone: ''
    });

    /* 打开编辑弹窗 */
    const openEdit = (row) => {
      current.value = row ?? null;
      showEdit.value = true;
    };

    const findAllPerson = () => {
      findAllPersonList()
        .then((data) => {
          personList.value = toRaw(data)
          message.success("查找成功")
        })
        .catch((e) => {
          message.error(e.message);
        });
    };

    const findPersonByPersonId = (personId) =>{
      findPersonService(personId)
        .then((data) => {
          personList.value = [toRaw(data)]
        })
        .catch((e) => {
          message.error(e.message);
        });
    };

    const deletePersonByPersonId = (personId) => {
      deletePersonService(personId)
        .then((msg) =>{
          message.success("删除成功")
          //刷新列表
          findAllPerson();
        })
        .catch((e)=>{
          message.error(e);
        })
    };

    const addPerson = (person) => {
      addPersonService(person)
        .then((msg) =>{
          message.success("保存成功")
          //刷新列表
          findAllPerson();
        })
    };
    const updatePerson = (person) => {
      updatePersonService(person)
        .then((msg) =>{
          message.success("修改成功")
          //刷新列表
          findAllPerson();
        })
    };

    const edit = (personSingle) =>{
      person.personId = personSingle.personId
      person.name = personSingle.name
      person.sex = personSingle.sex
      person.age = personSingle.age
      person.major = personSingle.major
      person.phone = personSingle.phone
    }

    mounted:{
      findAllPerson()
    }
    return {
      personId,
      personList,
      findAllPerson,
      person,
      personForSave,
      findPersonByPersonId,
      deletePersonByPersonId,
      addPerson,
      updatePerson,
      edit
    };
  }
};
</script>

<style scoped></style>

