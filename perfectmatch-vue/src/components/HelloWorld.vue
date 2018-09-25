<template>
  <div class="service">
    <h1>{{ msg }}</h1>
    <h2>REST service call results</h2>

    <button @click="callRestService()">CALL Spring Boot REST backend service</button>
      <b-btn id="exPopoverReactive1"
             :disabled="popoverShow"
             variant="primary"
             ref="button">
        Reactive Content Using Slots
      </b-btn>
    <h4>Backend response: {{ response }}</h4>
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
  </div>
</template>

<script>
// import axios from 'axios'
import {findByRepoUsingGET} from './api'
export default {
  name: 'service',

  data () {
    return {
      msg: 'HowTo call REST-Services:',
      response: [],
      errors: []
    }
  },
  methods: {
    // Fetches posts when the component is created.
    callRestService () {
      let params = {$domain: 'http://localhost:8081'}
      findByRepoUsingGET(params)
        .then(response => {
          // JSON responses are automatically parsed.
          this.response = response.data
          console.log(response.data)
        })
        .catch(e => {
          this.errors.push(e)
        })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1, h2 {
    font-weight: normal;
  }

  ul {
    list-style-type: none;
    padding: 0;
  }

  li {
    display: inline-block;
    margin: 0 10px;
  }

  a {
    color: #42b983;
  }
</style>
