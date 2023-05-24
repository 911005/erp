import axios from 'axios';


export class demoService{
  static findCarInfos () {
    return axios.request({
      url: '/api/car/car/findAllCArs',
      method: 'POST',
    });
  }

  static deleteCar (rowId) {
    query ={
      rowId
    }
    return axios({
      url: '/car/car/deleteCar',
      data: query,
      method: 'GET'
    });
  }
}
