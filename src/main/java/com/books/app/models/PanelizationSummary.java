package com.books.app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class PanelizationSummary {

   boolean containsEpubBubbles;
   boolean containsImageBubbles;

   public PanelizationSummary() {
   }

   public PanelizationSummary(boolean containsEpubBubbles, boolean containsImageBubbles) {
      this.containsEpubBubbles = containsEpubBubbles;
      this.containsImageBubbles = containsImageBubbles;
   }

   public boolean isContainsEpubBubbles() {
      return containsEpubBubbles;
   }

   public void setContainsEpubBubbles(boolean containsEpubBubbles) {
      this.containsEpubBubbles = containsEpubBubbles;
   }

   public boolean isContainsImageBubbles() {
      return containsImageBubbles;
   }

   public void setContainsImageBubbles(boolean containsImageBubbles) {
      this.containsImageBubbles = containsImageBubbles;
   }
}
