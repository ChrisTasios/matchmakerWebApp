<script setup>
//Imports
import {reactive, ref} from "vue";
import axios from "axios";
import {useRouter} from "vue-router";

const userDto = reactive({
  name: '',
  email: '',
  password: ''
})

const errorMessages = ref('')
const router = useRouter()
//Functions
const registerUser = () => {
  errorMessages.value = ''
  axios.post('/api/users', userDto)
      .then(res => {
        router.push(res.headers['location'])
      }).catch((error) => {
        errorMessages.value = error.response.data.message
  })
  clearFields()
}

function clearFields() {
  userDto.name = '';
  userDto.email = '';
  userDto.password = '';
}

// Validation Rules
function required (v) {
  return !!v || 'Field is required'
}

const emailRules = [
  value => !!value || 'Required.',
  value => (value || '').length <= 20 || 'Max 20 characters',
  value => {
    const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
    return pattern.test(value) || 'Invalid e-mail.'
  },
]
</script>

<template>
  <v-container width="350px">
    <v-text-field
        v-model="userDto.name"
        clearable
        color="primary"
        label="Full name"
        :rules="[required]"
        variant="underlined"
    />

    <v-text-field
        v-model="userDto.email"
        clearable
        color="primary"
        label="Email"
        type="email"
        required
        :rules="emailRules"
        variant="underlined"
    />

    <v-text-field
        v-model="userDto.password"
        clearable
        color="primary"
        label="Password"
        placeholder="Enter your password"
        variant="underlined"
        :rules="[required]"
    />
    <span class="text-red font-italic">{{errorMessages}}</span>

  </v-container>

  <v-divider/>

  <v-card-actions>
    <v-spacer/>

    <v-btn color="success" @click="registerUser">
      Complete Registration
      <v-icon end icon="mdi-chevron-right"/>
    </v-btn>
  </v-card-actions>
</template>

<style scoped>

</style>