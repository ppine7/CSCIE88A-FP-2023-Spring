package cscie88a.week3;

public class AdoptionService {

    public boolean tryToAdoptNoArg(
            IAdoptable someoneToAdopt, boolean adoptionFeePaid) {
        if (someoneToAdopt.readyForAdoptionNoArg() && adoptionFeePaid) {
            return true;
        } else
            return false;
    }

    public boolean tryToAdoptOneArg(IAdoptable2 someoneToAdopt, boolean healthCheckDone, boolean adoptionFeePaid) {
        if (someoneToAdopt.readyForAdoptionOneArg(healthCheckDone) && adoptionFeePaid) {
            return true;
        } else
            return false;
    }

}
