<template>
  <div class="container">
    <div>
      <logo />
      <ul>
        <li v-for="item in items">{{ item.name }}</li>
      </ul>
    </div>
    <div class='div-btn'>
      <nuxt-link to='/' class='button--grey'>index</nuxt-link>
    </div>
  </div>
</template>
<script lang="ts">
import axios from 'axios'
export default {
  async asyncData () {
    return axios.get('api/v1/view/csr')
      .then((res) => {
        return { items: res.data }
      })
  }
}
</script>
