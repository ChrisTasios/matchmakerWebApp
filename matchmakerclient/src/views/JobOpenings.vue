<template>
  <v-table
      height="300px"
      fixed-header
      v-if="jobs.length > 0"
  >
    <thead>
    <tr>
      <th class="text-left">
        Company
      </th>
      <th class="text-left">
        Position
      </th>
    </tr>
    </thead>
    <tbody>
    <tr
        v-for="item in jobs"
        :key="item.id"
    >
      <td>{{ item.name }}</td>
      <td>{{item.company}}</td>
    </tr>
    </tbody>
  </v-table>
  <v-btn class="mt-3" color="success" @click="fetchAvailableJobs">Find your Match</v-btn>
</template>

<script setup>
import {ref} from "vue";
import axios from "axios";

const props = defineProps({
  skills: {
    default: () => []
  }
})

function fetchAvailableJobs() {
  const skillList = []
  for (let i = 0; i < props.skills.length; i++) {
    skillList[i] = {
      skill: props.skills[i].skill,
      userId: props.skills[i].userId
    }
  }

  axios.post("/api/proposedPositions", skillList).then((response) => {
    jobs.value = response.data
  })
}

const jobs = ref([])
</script>