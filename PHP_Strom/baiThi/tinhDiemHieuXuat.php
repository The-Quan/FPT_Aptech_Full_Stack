<?php

function calculatePerformance($totalLeaveDays, $workDaysInMonth, $exportRatio)
{
    $maxLeaveDays = 12;
    $maxWorkDays = 22;

    $leaveScore = ($maxLeaveDays - $totalLeaveDays) >= 0 ? 12 : 0;
    $workScore = min($workDaysInMonth, $maxWorkDays) * $exportRatio;

    return $leaveScore + $workScore;
}