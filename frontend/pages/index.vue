<template>
  <div class="container">
    <div>
      <ul>
        <li v-for="user in users" :key="user.id">{{ user.name }}</li>
      </ul>
    </div>
  </div>
</template>
<script lang="ts">
import { Component, Vue } from 'nuxt-property-decorator'
import { IUser } from '~/models/user'
import { getUsers } from '~/libs/api'

@Component({
  components: {},
  async asyncData () {
    const responseUsers: IUser[] = await getUsers();
    return { users: responseUsers };
  }
})
export default class extends Vue {
  private users?: IUser[]

  /*
  get Users() {
    return this.users;
  }

  set Users(users: IUser[]) {
    this.users = users;
  }

  // csr
  created() {
    this.users = getUsers().then((responseUsers: IUser[]) => this.users = responseUsers);
  }
   */
}
</script>
