/**
 * @param {number} initialEnergy
 * @param {number} initialExperience
 * @param {number[]} energy
 * @param {number[]} experience
 * @return {number}
 */
var minNumberOfHours = function (initialEnergy, initialExperience, energy, experience) {
    let res = 0;
    for (let i = 0; i < energy.length; i++) {
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
                initialExperience += experience[i] - initialExperience + 1
            }

            initialEnergy -= energy[i];
            initialExperience += experience[i];
        }
    }
    return res;
};