
def canShip(weights, daysHave, capacity):
    daysNeeded = 0
    currentWeightsSum = 0
    for weight in weights:
        if currentWeightsSum + weight <= capacity:
            currentWeightsSum += weight
        else:
            daysNeeded += 1
            currentWeightsSum = weight
    if currentWeightsSum != 0:
        daysNeeded += 1
    return daysNeeded <= daysHave
class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        low = max(weights)
        high = sum(weights)
        while low < high:
            mid = (low + high) // 2
            if canShip(weights, days, mid):
                high = mid
            else:
                low = mid + 1
        return low