class MinNumberOfHours {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int res = 0;
        for (int i = 0; i < energy.length; i++) {
            if (initialEnergy > energy[i] && initialExperience > experience[i]) {
                initialEnergy -= energy[i];
                initialExperience += experience[i];
                continue;
            } else {

                if (energy[i] >= initialEnergy) {
                    res += energy[i] - initialEnergy + 1;
                    initialEnergy += energy[i] - initialEnergy + 1;
                }
                if (experience[i] >= initialExperience) {
                    res += experience[i] - initialExperience + 1;
                    initialExperience += experience[i] - initialExperience + 1;
                }

                initialEnergy -= energy[i];
                initialExperience += experience[i];
            }
        }
        return res;
    }
}