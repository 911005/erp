<template>
  <div class="container">
    <div class="left-panel">
      <ul>
        <li v-for="node in treeData" :key="node.id" @click="selectNode(node)">
          {{ node.label }}
        </li>
      </ul>
    </div>
    <div class="right-panel">
      <table>
        <thead>
        <tr>
          <th>属性名</th>
          <th>属性值</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(config, index) in selectedNode.configs" :key="index">
          <td>{{ config.name }}</td>
          <td>{{ config.value }}</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
export default {
  name:"index",
  data() {
    return {
      treeData: [
        {
          id: 1,
          label: "节点 A",
          configs: [
            { name: "属性1", value: "值1" },
            { name: "属性2", value: "值2" },
          ],
          children: [
            {
              id: 2,
              label: "节点 A-1",
              configs: [{ name: "属性3", value: "值3" }],
            },
            {
              id: 3,
              label: "节点 A-2",
              configs: [{ name: "属性4", value: "值4" }],
            },
          ],
        },
        // 其他节点
      ],
      selectedNode: null, // 当前选中的节点
    };
  },
  methods: {
    selectNode(node) {
      this.selectedNode = node;
    },
  },
};
</script>







<!--<template>-->
<!--  <div class="detail">-->
<!--    <div class="detail-content">-->
<!--      <div class="detail-content-left">-->
<!--        <div>-->
<!--          <el-tree-->
<!--            :data="data"-->
<!--            :props="defaultProps"-->
<!--            @node-click="handleNodeClick"-->
<!--          />-->
<!--        </div>-->
<!--      </div>-->

<!--      <div class="detail-content-right">-->
<!--        <div-->
<!--          v-for="(item, index) in list"-->
<!--          :key="index"-->
<!--          class="scroll-item"-->
<!--        >-->
<!--          <div>{{ item.title }}</div>-->
<!--          <div>{{ item.content }}</div>-->
<!--        </div>-->
<!--      </div>-->
<!--    </div>-->
<!--  </div>-->
<!--</template>-->
<!--<script>-->
<!--export default {-->
<!--  data() {-->
<!--    return {-->
<!--      clickdata:"",-->
<!--      data: [-->
<!--        {-->
<!--          label: "一级 1"-->
<!--        },-->
<!--        {-->
<!--          label: "一级 2"-->
<!--        },-->
<!--        {-->
<!--          label: "一级 3",-->
<!--          children: [-->
<!--            {-->
<!--              label: "二级 3-1",-->
<!--              children: [-->
<!--                {-->
<!--                  label: "三级 3-1-1"-->
<!--                }-->
<!--              ]-->
<!--            },-->
<!--            {-->
<!--              label: "二级 3-2",-->
<!--              children: [-->
<!--                {-->
<!--                  label: "三级 3-2-1"-->
<!--                }-->
<!--              ]-->
<!--            }-->
<!--          ]-->
<!--        }-->
<!--      ],-->
<!--      defaultProps: {-->
<!--        children: "children",-->
<!--        label: "label"-->
<!--      },-->
<!--      list: [-->
<!--        {-->
<!--          title: "1",-->
<!--          content: "1-1"-->
<!--        },-->
<!--        {-->
<!--          title: "2",-->
<!--          content: "2-2"-->
<!--        },-->
<!--        {-->
<!--          title: "3",-->
<!--          content: "3-2"-->
<!--        },-->
<!--        {-->
<!--          title: "1",-->
<!--          content: "1-1"-->
<!--        },-->
<!--        {-->
<!--          title: "2",-->
<!--          content: "2-2"-->
<!--        },-->
<!--        {-->
<!--          title: "3",-->
<!--          content: "3-2"-->
<!--        },-->
<!--        {-->
<!--          title: "1",-->
<!--          content: "1-1"-->
<!--        },-->
<!--        {-->
<!--          title: "2",-->
<!--          content: "2-2"-->
<!--        },-->
<!--        {-->
<!--          title: "3",-->
<!--          content: "3-2"-->
<!--        },-->
<!--        {-->
<!--          title: "1",-->
<!--          content: "1-1"-->
<!--        },-->
<!--        {-->
<!--          title: "2",-->
<!--          content: "2-2"-->
<!--        },-->
<!--        {-->
<!--          title: "3",-->
<!--          content: "3-2"-->
<!--        },-->
<!--        {-->
<!--          title: "1",-->
<!--          content: "1-1"-->
<!--        },-->
<!--        {-->
<!--          title: "2",-->
<!--          content: "2-2"-->
<!--        },-->
<!--        {-->
<!--          title: "3",-->
<!--          content: "3-2"-->
<!--        },-->
<!--        {-->
<!--          title: "1",-->
<!--          content: "1-1"-->
<!--        }-->
<!--      ]-->
<!--    };-->
<!--  },-->
<!--  computed: {},-->
<!--  created() {-->
<!--  },-->
<!--  methods: {-->
<!--    handleNodeClick(data) {-->
<!--      this.clickdata = data.$treeNodeId;-->
<!--      console.log(this.clickdata);-->
<!--      this.scrollTo(this.clickdata);-->
<!--    },-->
<!--    // 滚动监听器-->
<!--    onScroll() {-->
<!--      // 获取所有锚点元素-->
<!--      const navContents = document.querySelectorAll(".scroll-item");-->
<!--      // 所有锚点元素的 offsetTop-->
<!--      const offsetTopArr = [];-->
<!--      navContents.forEach(item => {-->
<!--        offsetTopArr.push(item.offsetTop);-->
<!--      });-->
<!--      // 获取当前文档流的 scrollTop-->
<!--      const scrollTop =-->
<!--        document.documentElement.scrollTop || document.body.scrollTop;-->
<!--      // 定义当前点亮的导航下标-->
<!--      let navIndex = 0;-->
<!--      for (let n = 0; n < offsetTopArr.length; n++) {-->
<!--        // 如果 scrollTop 大于等于第n个元素的 offsetTop 则说明 n-1 的内容已经完全不可见-->
<!--        // 那么此时导航索引就应该是n了-->
<!--        if (scrollTop >= offsetTopArr[n]) {-->
<!--          navIndex = n;-->
<!--        }-->
<!--      }-->
<!--      this.active = navIndex;-->
<!--    },-->
<!--    // 跳转到指定索引的元素-->
<!--    scrollTo(index) {-->
<!--      // 获取目标的 offsetTop-->
<!--      // css选择器是从 1 开始计数，我们是从 0 开始，所以要 +1-->
<!--      const targetOffsetTop = document.querySelector(-->
<!--        `.scroll-item:nth-child(${index + 1})`-->
<!--      ).offsetTop;-->
<!--      // 获取当前 offsetTop-->
<!--      let scrollTop =-->
<!--        document.documentElement.scrollTop || document.body.scrollTop;-->
<!--      // 定义一次跳 50 个像素，数字越大跳得越快，但是会有掉帧得感觉，步子迈大了会扯到蛋-->
<!--      const STEP = 50;-->
<!--      // 判断是往下滑还是往上滑-->
<!--      if (scrollTop > targetOffsetTop) {-->
<!--        // 往上滑-->
<!--        smoothUp();-->
<!--      } else {-->
<!--        // 往下滑-->
<!--        smoothDown();-->
<!--      }-->
<!--      // 定义往下滑函数-->
<!--      function smoothDown() {-->
<!--        // 如果当前 scrollTop 小于 targetOffsetTop 说明视口还没滑到指定位置-->
<!--        if (scrollTop < targetOffsetTop) {-->
<!--          // 如果和目标相差距离大于等于 STEP 就跳 STEP-->
<!--          // 否则直接跳到目标点，目标是为了防止跳过了。-->
<!--          if (targetOffsetTop - scrollTop >= STEP) {-->
<!--            scrollTop += STEP;-->
<!--          } else {-->
<!--            scrollTop = targetOffsetTop;-->
<!--          }-->
<!--          document.body.scrollTop = scrollTop;-->
<!--          document.documentElement.scrollTop = scrollTop;-->
<!--          // 关于 requestAnimationFrame 可以自己查一下，在这种场景下，相比 setInterval 性价比更高-->
<!--          requestAnimationFrame(smoothDown);-->
<!--        }-->
<!--      }-->
<!--      // 定义往上滑函数-->
<!--      function smoothUp() {-->
<!--        if (scrollTop > targetOffsetTop) {-->
<!--          if (scrollTop - targetOffsetTop >= STEP) {-->
<!--            scrollTop -= STEP;-->
<!--          } else {-->
<!--            scrollTop = targetOffsetTop;-->
<!--          }-->
<!--          document.body.scrollTop = scrollTop;-->
<!--          document.documentElement.scrollTop = scrollTop;-->
<!--          requestAnimationFrame(smoothUp);-->
<!--        }-->
<!--      }-->
<!--    }-->
<!--  },-->
<!--  destroy() {-->
<!--    // 必须移除监听器，不然当该vue组件被销毁了，监听器还在就会出错-->
<!--    window.removeEventListener("scroll", this.onScroll);-->
<!--  }-->
<!--};-->
<!--</script>-->
<!--<style lang="scss" scoped>-->
<!--// 此处使用scss如若less改成less即可-->
<!--.detail {-->
<!--  width: 1009px;-->
<!--  &-content {-->
<!--    display: flex;-->
<!--    justify-content: space-between;-->
<!--    &-left {-->
<!--      background: #fff;-->
<!--      width: 220px;-->
<!--      padding: 10px 0 0 20px;-->
<!--      div {-->
<!--        background: #fff;-->
<!--      }-->
<!--    }-->
<!--    &-right {-->
<!--      width: 780px;-->
<!--      background: #fff;-->
<!--      margin-left: 9px;-->
<!--      padding: 20px;-->
<!--    }-->
<!--  }-->
<!--}-->
<!--</style>-->




<!--<script>-->
<!--import { createApp } from 'vue'-->
<!--import ElementPlus from 'element-plus'-->
<!--import 'element-plus/dist/index.css'-->
<!--import index from './index.vue'-->
<!--import tree from '../components/tree.vue'-->

<!--export default {-->
<!--  name: "index",-->
<!--  components:{-->
<!--    tree-->
<!--  },-->
<!--  setup(){-->

<!--    const app = createApp(index)-->
<!--    app.use(ElementPlus)-->
<!--    app.mount('#app')-->
<!--  }-->

<!--}-->
<!--</script>-->

<!--<style scoped>-->

<!--</style>-->
