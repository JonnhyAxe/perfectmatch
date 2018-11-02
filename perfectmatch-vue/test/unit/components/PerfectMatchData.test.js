import PerfectMatch from '@/components/PerfectMatch'
import { shallowMount } from '@vue/test-utils'
import axios from 'axios' // axios here is the mock from above!
import Vue from 'vue'

Vue.use(axios)


jest.mock('axios', () => ({
  get: jest.fn(() => Promise.resolve({'response': { status: 200 }}))
}))

describe('PerfectMatch.vue', () => {
  let cmp

  beforeEach(() => {
    axios.get.mockClear()
    axios.get.mockReturnValue(Promise.resolve({}))
   
    cmp = shallowMount(PerfectMatch, {
      data () {
        return {
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
      }
    })
  })

  it.skip('equals tables items to predefined array', () => {
    expect(cmp.vm.musics).toEqual([{"artist": "Latmun", "id": "5baf59c9f0139422206e6411", "name": "Please Stop (Original Mix)", "samples": [{"id": "5baf59c9f0139422206e640f", "mathes": [{"id": "5baf59c9f0139422206e640e", "name": "Latmun:Please Stop (Original Mix)"}], "name": "Latmun:Please Stop (Original Mix)", "timestamp": 180}], "style": "TECH_HOUSE"}])
  })
  
  it.skip('should render empty table', () => {
    console.log(cmp);
    
    const table = cmp.find('b-table')
    expect(table.attributes('fields')).toEqual('artist,name,show_details')
    expect(table.attributes().fields).toBe('artist,name,show_details')
    expect(table.text()).toEqual('')
    expect(table.classes()).toEqual([])
  })
})
