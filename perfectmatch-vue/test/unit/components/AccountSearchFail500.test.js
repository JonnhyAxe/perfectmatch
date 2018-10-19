import { shallowMount } from '@vue/test-utils'
import AccountSearch from '@/components/accounts/AccountSearch.vue'
import axios from 'axios' // axios here is the mock from above!
import Vue from 'vue'
import VueSimpleSuggest from 'vue-simple-suggest'
import BootstrapVue from 'bootstrap-vue'
import VueResource from 'vue-resource'
import DatePicker from 'vue2-datepicker'

Vue.use(BootstrapVue)
Vue.use(VueResource)
Vue.use(BootstrapVue)
Vue.use(VueSimpleSuggest)
Vue.use(DatePicker)
Vue.use(axios)

Vue.component('vue-suggest', VueSimpleSuggest)

jest.mock('axios', () => ({
  get: jest.fn(() => Promise.resolve({}))
}))

describe('AccountSearch.vue', () => {
  let accountSearchWrapped

  beforeEach(() => {
    axios.get.mockClear()
    axios.get.mockReturnValue(Promise.resolve({
      'response': { status: 500 },
      'error': { message: 'internal server error' }
    }))
    accountSearchWrapped = shallowMount(AccountSearch, {})
  })

  it('show message if bad response from server', () => {
    const errorSection = accountSearchWrapped.find('#errorSection')

    expect(errorSection.text()).toContain('[Platforms list]')
    expect(errorSection.text()).toContain('[Sales list]')
    expect(errorSection.text()).toContain('[prime-broker list]')
  })
})
