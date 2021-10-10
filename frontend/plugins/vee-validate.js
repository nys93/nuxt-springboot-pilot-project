import Vue from 'vue'
import {
  ValidationProvider,
  ValidationObserver,
  localize,
  extend,
} from 'vee-validate'
import * as defaultRules from 'vee-validate/dist/rules' // 기본룰을 등록
import ja from 'vee-validate/dist/locale/ja'

// 에러메세지 커스텀도 여기서 가능
for (const rule in defaultRules) {
  extend(rule, { ...defaultRules[rule] }) // eslint-disable-line
}

Vue.component('ValidationProvider', ValidationProvider)
Vue.component('ValidationObserver', ValidationObserver)
localize('ja', ja)
