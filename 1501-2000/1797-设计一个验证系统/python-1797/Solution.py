class AuthenticationManager:

    def __init__(self, timeToLive: int):
        self.timeToLive = timeToLive
        self.map = dict()

    def generate(self, tokenId: str, currentTime: int) -> None:
        self.map[tokenId] = currentTime

    def renew(self, tokenId: str, currentTime: int) -> None:
        if tokenId in self.map:
            time = self.map.get(tokenId)
            if time + self.timeToLive > currentTime:
                self.map[tokenId] = currentTime

    def countUnexpiredTokens(self, currentTime: int) -> int:
        res = 0
        for time in self.map.values():
            if time + self.timeToLive > currentTime:
                res += 1
        return res


# Your AuthenticationManager object will be instantiated and called as such:
# obj = AuthenticationManager(timeToLive)
# obj.generate(tokenId,currentTime)
# obj.renew(tokenId,currentTime)
# param_3 = obj.countUnexpiredTokens(currentTime)