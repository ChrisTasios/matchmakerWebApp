<template>
  <v-card class="mx-auto" width="350px">
    <v-card-title>
      Registered Skills
    </v-card-title>

    <v-divider></v-divider>

    <v-virtual-scroll
        v-if="submittedSkills.length"
        :items="submittedSkills"
        height="220"
        item-height="30"
    >
      <template v-slot:default="{ item }">
        <v-list-item
            :title="`${item.skill.toUpperCase()}`"
        >

          <template v-slot:append>
            <v-btn
                icon="mdi-delete"
                size="x-small"
                variant="tonal"
                class="ml-4"
                @click="removeSkill(item)"
            />
          </template>
        </v-list-item>
      </template>
    </v-virtual-scroll>

    <div v-else class="pa-4 text-medium-emphasis text-center">
      Insert your skills so to find a related job.
    </div>
    <v-combobox
        v-model="selectedSkills"
        :items="existingSkills"
        label="Enter more of your skills"
        chips
        multiple
    >
      <template #prepend-inner>
        <v-btn
            icon="mdi-plus"
            variant="text"
            size="small"
            @click="insertSkills"
        />
      </template>
    </v-combobox>
  </v-card>
</template>


<script setup>
import {onBeforeMount, ref} from "vue";
import axios from "axios";
import {useRoute} from "vue-router";

const route = useRoute()
const submittedSkills = ref([])
const emit = defineEmits(['updateSkill'])

onBeforeMount(() => {
  fetchSkills()
  selectedSkills.value = []
})

function fetchSkills() {
  const url = "/api/skills/" + route.params.id
  axios.get(url).then(response => {
    submittedSkills.value = response.data;
    emit('updateSkill', submittedSkills.value);
  })
}

const insertSkills = () => {
  const skills = selectedSkills.value;
  const formattedSkills = []
  for (let i = 0; i < skills.length; i++) {
    formattedSkills[i] = {
      skill: skills[i],
      userId: route.params.id,
    }
  }
  console.log(formattedSkills)
  axios.post("/api/skills", formattedSkills).then((response) => {
    fetchSkills()
    selectedSkills.value = []
  })
}

const removeSkill = (item) => {
  axios.delete("/api/skills", {
    data: {
      userId: item.userId,
      skill: item.skill,
      skillId: item.skillId
    }
  }).then(() => {
    fetchSkills(); // refresh list
  }).catch((error) => {
    console.error("Failed to delete skill:", error);
  });
}

const selectedSkills = ref([])

const existingSkills = [
  'Docker',
  'Java',
  'MS Office',
  'Talkative',
]


</script>