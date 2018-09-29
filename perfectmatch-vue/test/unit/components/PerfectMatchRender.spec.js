import PerfectMatch from '@/components/PerfectMatch'
import { mount } from '@vue/test-utils'

describe('PerfectMatch.vue', () => {
  it('should render empty table', () => {
    const wrapper = mount(PerfectMatch)
    const table = wrapper.find('b-table')
    expect(table.attributes('fields')).toEqual('artist,name,show_details')
    expect(table.attributes().fields).toBe('artist,name,show_details')
    expect(table.text())
      .toEqual('')
    expect(table.classes()).toEqual([])
  })
})
