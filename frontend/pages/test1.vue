<template>
  <div>
    <!-- asyncData 메소드에서 전달한 데이터를 마크업에 연결 -->
    <ul>
      <li v-for="user in list">{{ user.name }}</li>
    </ul>
  </div>
</template>

<script>
export default {
  // Nuxt.js에서 제공하는 페이지 로딩 전에 비동기 데이터를 호출하기 위한 메소드
  // Vue.js의 data 메소드와 유사한 역할을 한다
  async asyncData({ app }) {
    // 설치 과정에서 axios 플러그인을 선택했다면 axios를 아래와 같은 형태로 사용 가능하다.
    const user = await app.$axios.$get(`/api/view/list2`)
    return { user }
  },

  // Nuxt.js에서 제공하는 head 태그 수정용 메소드
  head() {
    return {
      title: `User | ${this.user.name}`, // asyncData에서 리턴한 user 데이터를 사용할 수 있다.
    }
  },
}
</script>
