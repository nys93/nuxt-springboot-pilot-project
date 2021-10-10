<template>
  <div class='container'>
    <div>
      <ValidationObserver
        ref='observer'
        v-slot='{ handleSubmit }'
        @submit.prevent
        tag='div'
        class='flex flex-col justify-center items-center'
      >
        <form>
          <ValidationProvider
            v-slot='{ errors }'
            rules='email|required'
            tag='div'
            class='bg-gray-500'
          >
            <label for='email'>email</label>
            <input id='email' type='text' v-model='email' />
            <label class='text-red-500'>{{ errors[0] }}</label>
          </ValidationProvider>
          <ValidationProvider
            v-slot='{ errors }'
            tag='div'
            rules='min:8|max:20|alpha_dash|required'
            class='bg-gray-500'
          >
            <label for='password'>password</label>
            <input id='password' type='text' v-model='password' />
            <label class='text-red-500'>{{ errors[0] }}</label>
          </ValidationProvider>
          <ValidationProvider
            v-slot='{ errors }'
            tag='div'
            :rules='{ required: true, regex: /^0[1-9][0-9]{0,4}-[0-9]{1,5}-[0-9]{1,5}$/ }'
            class='bg-gray-500'
          >
            <label for='telephone'>telephone</label>
            <input id='telephone' type='text' v-model='telephone' />
            <label class='text-red-500'>{{ errors[0] }}</label>
          </ValidationProvider>
          <ValidationProvider
            v-slot='{ errors }'
            tag='div'
            :rules='{ required: { allowFalse: false } }'
            class='bg-gray-500'
          >
            <label for='checkbox'>checkbox</label>
            <input id='checkbox' type='checkbox' v-model='checkbox' />
            <label class='text-red-500'>{{ errors[0] }}</label>
          </ValidationProvider>


          <div class='w-full h-full m-10'>
            <button class='w-32 h-10 bg-blue-500 focus:ring-2' @click='handleSubmit(submit)'>
              Button
            </button>
          </div>
        </form>
        <p v-if='errorMessage' class='text-red-400'>{{ errorMessage }}</p>
      </ValidationObserver>
      <!--
      <ul>
        <li v-for='user in users' :key='user.id'>{{ user.name }}</li>
      </ul>
      -->
    </div>
  </div>
</template>
<script lang='ts'>
import { Component, Vue } from 'nuxt-property-decorator'
import { IUser, ICreateUser } from '~/models/user'
import { getUsers, createUsers } from '~/libs/apis/users'
import { IResponse } from '~/models/response';


@Component({
  components: {},
  // 렌더링 전에 동기 처리(for SSR)
  async asyncData () {
    const responseUsers: IUser[] = await getUsers();
    return { users: responseUsers };

  }
})
export default class extends Vue {
  private users?: IUser[];

  private email: string = "";
  private password: string = "";
  private telephone: string = "";
  private checkbox: boolean = false;
  private errorMessage: string = "";

  private submit() {
    const createUser: ICreateUser = {
      email: this.email,
      password: this.password,
      telephone: this.telephone,
      checkbox: this.checkbox,
    }
    // 비동기처리
    createUsers(createUser)
      .then((r: IResponse) => {
        console.log(r);
        alert(r.message);
      })
      .catch((e) => {
        console.error(e);
        alert("システムに障害が発生しました。");
      })
  }
}



</script>
