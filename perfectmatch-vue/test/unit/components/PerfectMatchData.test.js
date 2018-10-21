// import PerfectMatch from '@/components/PerfectMatch'
import { shallowMount } from '@vue/test-utils'
import Vue from 'vue'

// import bTable from 'bootstrap-vue/es/components/table/table';
// Vue.component('b-table', bTable);

describe('PerfectMatch.vue', () => {
  let cmp

  beforeEach(() => {
    cmp = shallowMount(PerfectMatch, {
      data: {
        musics: [
          {
            'id': '5baf59c9f0139422206e6411',
            'artist': 'Latmun',
            'name': 'Please Stop (Original Mix)',
            'style': 'TECH_HOUSE',
            'samples': [
              {
                'id': '5baf59c9f0139422206e640f',
                'name': 'Latmun:Please Stop (Original Mix)',
                'timestamp': 180,
                'mathes': [
                  {
                    'id': '5baf59c9f0139422206e640e',
                    'name': 'Latmun:Please Stop (Original Mix)'
                  }
                ]
              }
            ]
          }
        ]
      }
    })
  })

  it.skip('equals messages to predefined music', () => {
    expect(cmp.vm.musics).toEqual([])
  })
})
