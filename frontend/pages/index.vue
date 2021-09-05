<template>
  <div class="container">
    <div>
      <logo />
      <ul>
        <li v-for="user in users" :key="user.id">{{ user.name }}</li>
      </ul>
    </div>
  </div>
</template>
<script lang="ts">
import { Action, Component, Vue } from "nuxt-property-decorator";
import axios from 'axios'
import Logo from "~/components/VuetifyLogo.vue";

interface User {
  id: number;
  name: string;
}

@Component({
  components: {
    Logo
  }
})
export default class extends Vue {
  users: User[] = [{ id: 0, name: "0" }];

  get Users() {
    return this.users;
  }

  created(){
    axios.get('http://localhost:8000/api/v1/view/ssr')
      .then((res: any) => {
        console.log(this.users);
        this.users = res.data;
      });
  }

  @Action
  async getUsers() {
    axios.get('http://localhost:8000/api/v1/view/ssr')
      .then((res: any) => {
        console.log(res);
        // this.users = res;
      });
  }
}
  /*
  data() {
    return {
      users: []
    }
  }

  mounted() {
    thi)s.getUserList();
  }

  methods() {
    function getUserList() {
      axios.get('http://localhost:8000/api/v1/view/ssr')
        .then((res: any) => {
          this.data().users = res;
        });
    }
  }
   */
</script>
