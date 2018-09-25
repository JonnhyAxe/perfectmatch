<template>
  <div class="service">
  <b-table :items="items" :fields="fields">
    <template slot="show_details" slot-scope="row">
      <!-- we use @click.stop here to prevent emitting of a 'row-clicked' event  -->
      <b-button size="sm" @click.stop="row.toggleDetails" class="mr-2">
       {{ row.detailsShowing ? 'Hide' : 'Show'}} Details
      </b-button>
      <!-- In some circumstances you may need to use @click.native.stop instead -->
      <!-- As `row.showDetails` is one-way, we call the toggleDetails function on @change -->
      <b-form-checkbox @click.native.stop @change="row.toggleDetails" v-model="row.detailsShowing">
        Details via check
      </b-form-checkbox>
    </template>
    <template slot="row-details" slot-scope="row">
      <b-card>
        <b-row class="mb-2">
          <b-col sm="3" class="text-sm-right"><b>Age:</b></b-col>
          <b-col>{{ row.item.age }}</b-col>
        </b-row>
        <b-row class="mb-2">
          <b-col sm="3" class="text-sm-right"><b>Is Active:</b></b-col>
          <b-col>{{ row.item.isActive }}</b-col>
        </b-row>
        <b-button size="sm" @click="row.toggleDetails">Hide Details</b-button>
      </b-card>
    </template>
  </b-table>
  <b-btn id="exPopoverReactive1"
             :disabled="popoverShow"
             variant="primary"
             ref="button">
        Add Person
      </b-btn>
 <!-- output from the popover interaction -->
    <b-card title="Returned values:" v-if="input1Return && input2Return">
      <p class="card-text" style="max-width:20rem;">
        Name: <strong>{{ input1Return }}</strong><br>
        Color: <strong>{{ input2Return }}</strong>
      </p>
    </b-card>

    <!-- Our popover title and content render container -->
    <!-- We use placement 'auto' so popover fits in the best spot on viewport -->
    <!-- We specify the same container as the trigger button, so that popover is close to button -->
    <b-popover target="exPopoverReactive1"
               triggers="click"
               :show.sync="popoverShow"
               placement="auto"
               container="myContainer"
               ref="popover"
               @show="onShow"
               @shown="onShown"
               @hidden="onHidden">
      <template slot="title">
        <b-btn @click="onClose" class="close" aria-label="Close">
          <span class="d-inline-block" aria-hidden="true">&times;</span>
        </b-btn>
        Interactive Content
      </template>
      <div>
        <b-form-group label="Name" label-for="pop1"
                      :state="input1state" horizontal class="mb-1"
                      description="Enter your name"
                      invalid-feedback="This field is required">
          <b-form-input ref="input1" id="pop1" :state="input1state" size="sm" v-model="input1" />
        </b-form-group>
        <b-form-group label="Color" label-for="pop2"
                      :state="input2state" horizontal class="mb-1"
                      description="Pick a color"
                      invalid-feedback="This field is required">
          <b-form-select size="sm" id="pop2" :state="input2state" v-model="input2" :options="options" />
        </b-form-group>
        <b-alert show class="small">
          <strong>Current Values:</strong><br>
          Name: <strong>{{ input1 }}</strong><br>
          Color: <strong>{{ input2 }}</strong>
        </b-alert>
        <b-btn @click="onClose" size="sm" variant="danger">Cancel</b-btn>
        <b-btn @click="onOk" size="sm" variant="primary">Ok</b-btn>
      </div>
    </b-popover>
  <b-btn v-b-modal.modal-center>Launch centered modal</b-btn>
  </div>
</template>

<script>
export default {
  data () {
    return {
      fields: [ 'first_name', 'last_name', 'show_details' ],
      items: [
        { isActive: true, age: 40, first_name: 'Dickerson', last_name: 'Macdonald' },
        { isActive: false, age: 21, first_name: 'Larsen', last_name: 'Shaw' },
        { isActive: false, age: 89, first_name: 'Geneva', last_name: 'Wilson', _showDetails: true },
        { isActive: true, age: 38, first_name: 'Jami', last_name: 'Carney' }
      ],
      msg: 'HowTo call REST-Services:',
      response: [],
      errors: [],
      name: '',
      names: []
    }
  }
}
</script>
