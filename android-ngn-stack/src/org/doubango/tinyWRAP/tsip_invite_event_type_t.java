/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.doubango.tinyWRAP;

public enum tsip_invite_event_type_t {
  tsip_i_newcall,
  tsip_i_prechecking,
  tsip_i_request,
  tsip_ao_request,
  tsip_o_ect_trying,
  tsip_o_ect_accepted,
  tsip_o_ect_completed,
  tsip_o_ect_failed,
  tsip_o_ect_notify,
  tsip_i_ect_requested,
  tsip_i_ect_newcall,
  tsip_i_ect_completed,
  tsip_i_ect_failed,
  tsip_i_ect_notify,
  tsip_m_early_media,
  tsip_m_updating,
  tsip_m_updated,
  tsip_m_local_hold_ok,
  tsip_m_local_hold_nok,
  tsip_m_local_resume_ok,
  tsip_m_local_resume_nok,
  tsip_m_remote_hold,
  tsip_m_remote_resume;

  public final int swigValue() {
    return swigValue;
  }

  public static tsip_invite_event_type_t swigToEnum(int swigValue) {
    tsip_invite_event_type_t[] swigValues = tsip_invite_event_type_t.class.getEnumConstants();
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (tsip_invite_event_type_t swigEnum : swigValues)
      if (swigEnum.swigValue == swigValue)
        return swigEnum;
    throw new IllegalArgumentException("No enum " + tsip_invite_event_type_t.class + " with value " + swigValue);
  }

  @SuppressWarnings("unused")
  tsip_invite_event_type_t() {
    this.swigValue = SwigNext.next++;
  }

  @SuppressWarnings("unused")
  tsip_invite_event_type_t(int swigValue) {
    this.swigValue = swigValue;
    SwigNext.next = swigValue+1;
  }

  @SuppressWarnings("unused")
  tsip_invite_event_type_t(tsip_invite_event_type_t swigEnum) {
    this.swigValue = swigEnum.swigValue;
    SwigNext.next = this.swigValue+1;
  }

  private final int swigValue;

  private static class SwigNext {
    private static int next = 0;
  }
}

