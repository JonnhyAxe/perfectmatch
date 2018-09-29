import PerfectMatch from '@/components/PerfectMatch'
import { mount } from '@vue/test-utils'
import Vue from 'vue'

describe('PerfectMatch.vue', () => {
  it('should render empty table', () => {
    const wrapper = mount(PerfectMatch)
    const vm = wrapper.vm
    const table = wrapper.find('b-table')
    expect(table.attributes('fields')).toEqual({'fields': 'artist,name,show_details', 'items': ''})
    expect(table.attributes().fields).toBe('artist,name,show_details')
    expect(table.text())
      .toEqual('')
    expect(table.classes()).toEqual([])
  })

  it('should render table with content', () => {
    const wrapper = mount(PerfectMatch)
    // const vm = wrapper.vm

    const cmp = Vue.extend(PerfectMatch) // Create a copy of the original component
  

    const vm = new cmp({
      data: { // Replace data value with this fake data
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
          },
          {
            'id': '5baf59c9f0139422206e6412',
            'artist': 'Latmun',
            'name': 'def (Original Mix)',
            'style': 'TECH_HOUSE',
            'samples': [
              {
                'id': '5baf59c9f0139422206e6410',
                'name': 'Latmun:def (Original Mix)',
                'timestamp': 180,
                'mathes': null
              }
            ]
          },
          {
            'id': '5baf59c9f0139422206e6413',
            'artist': 'LatmunXPTO',
            'name': 'Please Stop (Original Mix)XPTO',
            'style': 'TECH_HOUSE',
            'samples': null
          }
        ]
      }
    }).$mount() // Instances and mounts the component

  })
})
