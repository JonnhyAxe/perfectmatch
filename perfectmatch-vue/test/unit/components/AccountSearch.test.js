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
  get: jest.fn(() => Promise.resolve({'response': { status: 200 }}))
}))

describe('AccountSearch.vue', () => {
  let accountSearchWrapped

  beforeEach(() => {
    axios.get.mockClear()
    axios.get.mockReturnValue(Promise.resolve({}))
    accountSearchWrapped = shallowMount(AccountSearch, {
     	data () {
        return {
          options: [
            { "text": "360T", "value": "360T" },
            { "text": "360TS", "value": "360TS" },
            { "text": "BBG", "value": "BBG" }],
          sales_options: [
            { "text": "Allison SILVER", "value": "Allison SILVER" }, 
            { "text": "Antonio FATOU QUIROS", "value": "Antonio FATOU QUIROS" }, 
            { "text": "Anastasia LEGOSTAEVA", "value": "Anastasia LEGOSTAEVA" }],
          pb_options: [
            { "text": "ABPMEZZAN", "value": "ABPMEZZAN" },
            { "text": "ABSOLUVEG", "value": "ABSOLUVEG" },
            { "text": "BACTTIINCBG", "value": "ACTTIINC" }]
        }
      }
    })
  })

  it('should load all options', () => {
    // When
    const venueOptions = accountSearchWrapped.find('#venueOptions').vm.$vnode.data.attrs['options']
    const salesOptions = accountSearchWrapped.find('#salesOptions').vm.$vnode.data.attrs['options']
    const pbOptions = accountSearchWrapped.find('#pbOptions').vm.$vnode.data.attrs['options']

    // Then
    expect(venueOptions).toEqual([
      { "text": "360T", "value": "360T" },
      { "text": "360TS", "value": "360TS" },
      { "text": "BBG", "value": "BBG" },
      { "text": "All", "value": null }
    ])
    expect(salesOptions).toEqual([
      { "text": "Allison SILVER", "value": "Allison SILVER" }, 
      { "text": "Antonio FATOU QUIROS", "value": "Antonio FATOU QUIROS" }, 
      { "text": "Anastasia LEGOSTAEVA", "value": "Anastasia LEGOSTAEVA" },
      { "text": "All", "value": null }
    ])
    expect(pbOptions).toEqual([
      { "text": "ABPMEZZAN", "value": "ABPMEZZAN" },
      { "text": "ABSOLUVEG", "value": "ABSOLUVEG" },
      { "text": "BACTTIINCBG", "value": "ACTTIINC" },
      { "text": "All", "value": null }
    ])
  })

  it('check account labels', () => {
    // When
    const venueOptions = accountSearchWrapped.find('#labelVenueOptions')
    const salesOptions = accountSearchWrapped.find('#labelSalesOptions')
    const pbOptions = accountSearchWrapped.find('#labelPbOptions')

    // Then
    expect(venueOptions.text()).toEqual('Venue:')
    expect(salesOptions.text()).toEqual('Sales:')
    expect(pbOptions.text()).toEqual('Prime Broker:')
  })
})
