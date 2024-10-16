package com.nodo.crudmongo.domain;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "product")
public class Product implements Serializable {

  @Id
  @NonNull
  private Long id;
  private String imgPath;
  private String title;
  private String description;


}
