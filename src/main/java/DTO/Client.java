package DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Client {
    @NonNull private String Code;
    @NonNull private String firstName;
    @NonNull private String lastName;
    @NonNull private String birthday;
    @NonNull private String telephone;
}
