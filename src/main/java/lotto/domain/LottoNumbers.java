package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<String> lottoNumbers) {
        this.lottoNumbers = lottoNumbers.stream()
                                .map(l -> new LottoNumber(Integer.parseInt(l)))
                                .collect(Collectors.toList());
    }

    public long compare(LottoNumbers winningNumbers) {
        return  lottoNumbers.stream()
                        .filter(l -> winningNumbers.isContainNumber(l))
                        .count();
    }

    protected boolean isContainNumber(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public List<String> getLottoNumbers() {
        return lottoNumbers.stream()
                .map(l -> l.getValue())
                .collect(Collectors.toList());
    }

    public boolean isContainBonusNumber(WinningLottoNumbers winningNumbers) {
        return isContainNumber(winningNumbers.getBonusNumber());
    }
}
