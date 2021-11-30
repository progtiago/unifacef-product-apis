package edu.unifacef.productapi.gateways.inputs.http.requests;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public abstract class ProductRequest implements Serializable {

  private static final long serialVersionUID = 3475925051912891191L;

  @ApiModelProperty(position = 1)
  @NotNull(message = "{required.field}")
  private String name;

  @ApiModelProperty(position = 2)
  private String description;

  @ApiModelProperty(position = 3)
  @NotNull(message = "{required.field}")
  private String brand;

  @ApiModelProperty(position = 4)
  @NotEmpty(message = "{required.field}")
  @Size(min = 1, max = 3, message = "{list.size}")
  private List<String> images;

  @ApiModelProperty(position = 5)
  private List<AttributeRequest> attributes;

}
