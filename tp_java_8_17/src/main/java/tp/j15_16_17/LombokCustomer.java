package tp.j15_16_17;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString 
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode
public class LombokCustomer {
	private Integer id;
	private String firstName;
	private String lastName;
}
