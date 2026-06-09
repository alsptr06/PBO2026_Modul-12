public class PenumpangValidator {

    public void validasiNIK(String nik) {
        if (nik.length() != 16) {
            throw new DataPenumpangTidakValidException("NIK harus 16 karakter");
        }
        for (int i = 0; i < nik.length(); i++) {
            if (!Character.isDigit(nik.charAt(i))) {
                throw new DataPenumpangTidakValidException("NIK hanya boleh angka");
            }
        }
    }
}
