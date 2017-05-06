import {BandMember} from "./bandmember.model";

export class Band {
  constructor(
    public name: string,
    public bandURL:string,
    public country:string,
    public bandMembers:BandMember[],
    public exBandMembers:BandMember[],
  ) {

  }
}
