import request from "@/utils/request";

//查询人物信息列表
export async function findAllPersonList(){
  const res = await request.get('/test/person');
  return res.data.data;

}

export async function findPersonService(data){
  const res = await request.get('/test/person/'+data);
  return res.data.data;
}

//删除人物信息
export async function deletePersonService(data){
  const res = await request.delete('/test/person/'+data);
  return res.data.data;
}
//新增
export async function addPersonService(data){
  data.tenantId = 2;
  const res = await request.post('/test/person/',data);
  return res.data.data;
}
//修改
export async function updatePersonService(data){
  const res = await request.put('/test/person/',data);
  return res.data.data;
}
