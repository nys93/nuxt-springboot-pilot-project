<template>
  <div class="container">
    <div>
      <ValidationObserver
        v-slot="{ handleSubmit }"
        tag="div"
        class="flex flex-col justify-center items-center"
      >
        <form @submit.prevent="handleSubmit(onSubmit)">
          <ValidationProvider
            v-slot="{ errors }"
            rules="email"
            tag="div"
            class="bg-gray-500"
          >
            <label for="email">email</label>
            <input id="email" type="text" v-model="email" />
            <label class="text-red-500">{{ errors[0] }}</label>
          </ValidationProvider>
          <ValidationProvider
            v-slot="{ errors }"
            tag="div"
            rules="min:8|max:20|alpha_dash"
            class="bg-gray-500"
          >
            <label for="password">password</label>
            <input id="password" type="text" v-model="password" />
            <label class="text-red-500">{{ errors[0] }}</label>
          </ValidationProvider>
          <div class="w-full h-full m-10">
            <button class="w-32 h-10 bg-blue-500 focus:ring-2" @click="onSubmit">
              Button
            </button>
          </div>
        </form>
        <p v-if="errorMessage" class="text-red-400">{{ errorMessage }}</p>
      </ValidationObserver>
      <!--
      <ul>
        <li v-for="user in users" :key="user.id">{{ user.name }}</li>
      </ul>
      -->
    </div>
  </div>
</template>
<script lang="ts">
import { Component, Vue } from 'nuxt-property-decorator'
import { IUser } from '~/models/user'
import { getUsers } from '~/libs/apis/api'


@Component({
  components: {},
  async asyncData () {
    const responseUsers: IUser[] = await getUsers();
    return { users: responseUsers };

  }
})
export default class extends Vue {
  private users?: IUser[]

  private email: string = "";
  private password: string = "";
  private errorMessage: string = "";

  private onSubmit() {
    if (this.email === "" || this.password === "") {
      this.errorMessage = "필수 입력이 빠져있습니다..";
      return;
    }

    console.log("Success!!");
  }
}



</script>
